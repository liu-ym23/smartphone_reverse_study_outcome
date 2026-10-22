package com.bytedance.ee.bear.doc.structure;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.util.ui.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mz4.d0;
import mz4.e0;
import mz4.p;
import mz4.w;
import vv4.k;
import zv4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class StructureViewModel extends ViewModel implements a<Structure> {
    private static final String TAG = "StructureViewModel";
    private final View.OnTouchListener contentTouchDispatcher;
    private View.OnTouchListener contentTouchListener;
    private final List<View.OnTouchListener> contentTouchListenerList;
    private boolean fixMode;
    private String floatingActiveContentId;
    private final MutableLiveData<Boolean> floatingBottomPanelVisible;
    private final MutableLiveData<Boolean> floatingStructureVisible;
    private boolean isUpdateActiveByFixedStructure;
    private final int[] scrollConsumed;
    private final f scrollDispatchProxy;
    private a.InterfaceC0046a scrollListener;
    private final int[] scrollOffset;
    private MutableLiveData<Structure> structure;
    private final w structureAnalytic;
    private k web;

    public static /* synthetic */ void Mo(StructureViewModel r0, View r1, int r2, int r3, int r4, int r5) {
        r0.dispatchScroll(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean yo(StructureViewModel r0, View r1, MotionEvent r2) {
        return r0.dispatchContentTouch(r1, r2);
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public int computeContentHeight() {
        return contentHeight(true);
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public int getContentHeight() {
        return contentHeight(false);
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public String getActive() {
        String r0 = this.floatingActiveContentId;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public LiveData<Structure> getContent() {
        if (this.structure != null) goto L6;
        this.structure = new MutableLiveData();
    L6:
        return this.structure;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public int getContentScroll() {
        k r0 = this.web;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getWebView().getScrollY();
    }

    public int getHeight() {
        k r0 = this.web;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWebView().getHeight();
    }

    public void onDetach() {
        this.web.removeOnTouchListener(this.contentTouchDispatcher);
        k r0 = this.web;
        if ((r0 instanceof z4) == false) goto L5;
        ((z4) r0).F(this.scrollDispatchProxy);
    L5:
        setStructure(null);
        this.web = null;
        this.floatingActiveContentId = null;
        this.contentTouchListenerList.clear();
    }

    public StructureViewModel() {
        this.scrollOffset = new int[2];
        this.scrollConsumed = new int[2];
        this.contentTouchDispatcher = new d0(this);
        this.contentTouchListenerList = new ArrayList();
        this.scrollDispatchProxy = new e0(this);
        this.floatingStructureVisible = new MutableLiveData();
        this.floatingBottomPanelVisible = new MutableLiveData();
        this.structureAnalytic = new w();
    }

    public MutableLiveData<Boolean> floatingBottomPanelVisible() {
        return this.floatingBottomPanelVisible;
    }

    public MutableLiveData<Boolean> floatingStructureVisible() {
        return this.floatingStructureVisible;
    }

    public w getStructureAnalytic() {
        return this.structureAnalytic;
    }

    public k getWeb() {
        return this.web;
    }

    public boolean isFixMode() {
        return this.fixMode;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public boolean isUpdateActiveByFixedStructure() {
        return this.isUpdateActiveByFixedStructure;
    }

    private int contentHeight(boolean r2) {
        k r0 = this.web;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r2 == false) goto L8;
        int r3 = ((z4) r0).computeVerticalScrollRange();
    L10:
        return r3 - getHeight();
    L8:
        r3 = ((z4) r0).r();
        goto L10
    }

    private void updateWebViewScrollBarStyle(boolean r3) {
        tt5.a.b(TAG, "updateWebViewScrollBarStyle:" + r3);
        k r0 = this.web;
        if (r0 == null) goto L6;
        r0.getWebView().setVerticalScrollBarEnabled(r3);
        return;
    }

    public void addContentTouchListener(View.OnTouchListener r2) {
        this.contentTouchListenerList.add(r2);
    }

    public void removeContentTouchListener(View.OnTouchListener r2) {
        this.contentTouchListenerList.remove(r2);
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void scrollTo(String r4) {
        if (this.web == null) goto L6;
        String r0 = String.format(Locale.ENGLISH, "window.lark.biz.navigation.jump", new Object[0]);
        JSONObject r1 = new JSONObject();
        r1.put("hash", r4);
        this.web.j(r0, r1);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setActive(String r1) {
        this.floatingActiveContentId = r1;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setContentScrollListener(a.InterfaceC0046a r1) {
        this.scrollListener = r1;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setContentTouchListener(View.OnTouchListener r1) {
        this.contentTouchListener = r1;
    }

    public void setFixMode(boolean r1) {
        this.fixMode = r1;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setIsUpdateActiveByFixedStructure(boolean r1) {
        this.isUpdateActiveByFixedStructure = r1;
    }

    public void setStructure(Structure r6) {
        MutableLiveData r0 = getContent();
        boolean r2 = true;
        boolean r1 = !Structure.equals((Structure) r0.getValue(), r6);
        tt5.a.h(TAG, "setStructure diff?" + r1);
        if (r1 == false) goto L10;
        r0.setValue(r6);
        if (r6 == null) goto L8;
        r2 = false;
    L8:
        updateWebViewScrollBarStyle(r2);
        return;
    }

    public void setWeb(k r2) {
        this.web = r2;
        r2.addOnTouchListener(this.contentTouchDispatcher);
        if ((r2 instanceof z4) == false) goto L6;
        ((z4) r2).d(this.scrollDispatchProxy);
        return;
    }

    private boolean dispatchContentTouch(View r3, MotionEvent r4) {
        Iterator<View.OnTouchListener> r0 = this.contentTouchListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View.OnTouchListener r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onTouch(r3, r4);
        goto L4
    L8:
        View.OnTouchListener r2 = this.contentTouchListener;
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.onTouch(r3, r4) == false) goto L13;
        return true;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void changeCollapseStatus(String r4, boolean r5) {
        String r0 = String.format(Locale.ENGLISH, "window.lark.biz.headings.switchHeading", new Object[0]);
        JSONObject r1 = new JSONObject();
        r1.put("hash", r4);
        r1.put("status", Boolean.valueOf(r5));
        this.web.j(r0, r1);
    }

    public void resetAnalytic(DocViewModel r2, d r3) {
        w r0 = this.structureAnalytic;
        r0.a = r2;
        r0.b = r3;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void scrollTo(int r5, int r6) {
        k r0 = this.web;
        if (r0 != null) goto L5;
        return;
    L5:
        WebView r1 = r0.getWebView();
        r1.startNestedScroll(2);
        if (r1.dispatchNestedPreScroll(0, r6 - r5, this.scrollConsumed, this.scrollOffset) == false) goto L8;
        r6 = r6 - this.scrollConsumed[1];
    L8:
        r1.stopNestedScroll();
        r1.scrollTo(0, r6);
    }

    private void dispatchScroll(View r2, int r3, int r4, int r5, int r6) {
        a.InterfaceC0046a r7 = this.scrollListener;
        if (r7 == null) goto L17;
        FloatingStructureFragment r8 = ((p) r7).a;
        if (r8.k.getVisibility() == 0) goto L10;
        if (r8.E == false) goto L10;
        tt5.a.b(r8.e, "GestureListener onscroll invalid");
        r8.V90();
        j.e(r8.y);
        j.d(r8.y, 2000);
    L10:
        if (r8.g.isFixMode() == true) goto L20;
        r8.ba0(r4);
        Structure r9 = (Structure) r8.g.getContent().getValue();
        if (r8.l == true) goto L18;
        if (r9 == null) goto L19;
        j.e(r8.B);
        j.e(r8.y);
        j.d(r8.y, 2000);
        return;
    L19:
        return;
    L18:
        return;
    L20:
        return;
    }
}
