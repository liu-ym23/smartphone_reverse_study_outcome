package com.bytedance.ee.bear.sheet.panel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import g45.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseCellPanelViewModel<T extends SheetItem> extends BaseEditPanelViewModel {
    private static final String TAG = "BaseCellPanelViewModel";
    private String[] badges;
    private a mDelegate;
    private MutableLiveData<T[]> mItems;
    private List<String> mNewSubItems;
    private Map<String, MutableLiveData<T[]>> mSubItems;
    private Map<String, String> mTitles;

    public interface a {
        <V> void a(String r1, V r2);
    }

    public abstract /* synthetic */ int getPanelHeight(Context r1);

    public abstract /* synthetic */ String getPanelName();

    private void removeUnusedSubItems() {
        Iterator<String> r0 = this.mSubItems.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        if (this.mNewSubItems.contains(r1) == true) goto L4;
        this.mSubItems.get(r1).setValue(null);
        r0.remove();
        goto L4
    }

    public BaseCellPanelViewModel() {
        this.mItems = new MutableLiveData();
        this.mSubItems = new HashMap();
        this.mNewSubItems = new ArrayList();
        this.mTitles = new HashMap();
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public MutableLiveData<T[]> getTopItems() {
        return this.mItems;
    }

    private void updateSubItems(T[] r7) {
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        T r2 = r7[r1];
        SheetItem[] r3 = r2.getItems();
        if (r3 != null) goto L7;
    L9:
        this.mTitles.put(r2.getId(), r2.getTitle());
    L10:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3.length <= 0) goto L9;
        SheetItem.sortByGroupId(r3);
        this.mNewSubItems.add(r2.getId());
        getSubItems(r2.getId()).setValue(r3);
        this.mTitles.put(r2.getId(), r2.getTitle());
        updateSubItems(r3);
        goto L10
    }

    public void clearBadges(String r4) {
        if (showBadges(r4) == false) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("panelName", getPanelName());
        r0.put("badges", new String[]{r4});
        execJS("javascript:window.lark.biz.sheet.clearBadges", r0);
        tt5.a.b(TAG, "clear badges: " + r0.toJSONString());
        return;
    }

    public String getPanelTitle(String r2) {
        String r3 = this.mTitles.get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public MutableLiveData<T[]> getSubItems(String r3) {
        MutableLiveData<T[]> r0 = this.mSubItems.get(r3);
        if (r0 != null) goto L6;
        MutableLiveData<T[]> r1 = new MutableLiveData();
        this.mSubItems.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public void setBadges(String[] r1) {
        this.badges = r1;
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public boolean showBadges(String r2) {
        String[] r0 = this.badges;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.asList(r0).contains(r2) == false) goto L7;
        return true;
    }

    public void updateItems(T[] r2) {
        this.mItems.setValue(r2);
        this.mNewSubItems.clear();
        updateSubItems(r2);
        removeUnusedSubItems();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <V> void clickItem(String r2, V r3) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = (V) "";
    L6:
        r0.a(r2, r3);
        return;
    }

    public void onBecomeActive(d r1, g45.a r2) {
        r1.requestUpdateWebContentHeight();
    }

    public void onBecomeInactive(d r1, g45.a r2) {
        setActive(false);
    }
}
