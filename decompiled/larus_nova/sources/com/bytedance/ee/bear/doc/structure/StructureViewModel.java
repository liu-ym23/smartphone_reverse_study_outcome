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

/* JADX INFO: loaded from: classes16.dex */
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
    private a.InterfaceC3102a scrollListener;
    private final int[] scrollOffset;
    private MutableLiveData<Structure> structure;
    private final w structureAnalytic;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private k f218200web;

    public static /* synthetic */ void Mo(StructureViewModel r100, View r101, int r102, int r103, int r104, int r105) {
        r100.dispatchScroll(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ boolean yo(StructureViewModel r100, View r101, MotionEvent r102) {
        return r100.dispatchContentTouch(r101, r102);
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
        String r100 = this.floatingActiveContentId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
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
        k r100 = this.f218200web;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getWebView().getScrollY();
    }

    public int getHeight() {
        k r100 = this.f218200web;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWebView().getHeight();
    }

    public void onDetach() {
        this.f218200web.removeOnTouchListener(this.contentTouchDispatcher);
        k r100 = this.f218200web;
        if ((r100 instanceof z4) == false) goto L5;
        ((z4) r100).F(this.scrollDispatchProxy);
    L5:
        setStructure(null);
        this.f218200web = null;
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
        return this.f218200web;
    }

    public boolean isFixMode() {
        return this.fixMode;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public boolean isUpdateActiveByFixedStructure() {
        return this.isUpdateActiveByFixedStructure;
    }

    private int contentHeight(boolean r100) {
        k r101 = this.f218200web;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r100 == false) goto L8;
        int r102 = ((z4) r101).computeVerticalScrollRange();
    L10:
        return r102 - getHeight();
    L8:
        r102 = ((z4) r101).r();
        goto L10
    }

    private void updateWebViewScrollBarStyle(boolean r100) {
        tt5.a.b(TAG, "updateWebViewScrollBarStyle:" + r100);
        k r101 = this.f218200web;
        if (r101 == null) goto L6;
        r101.getWebView().setVerticalScrollBarEnabled(r100);
        return;
    }

    public void addContentTouchListener(View.OnTouchListener r100) {
        this.contentTouchListenerList.add(r100);
    }

    public void removeContentTouchListener(View.OnTouchListener r100) {
        this.contentTouchListenerList.remove(r100);
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void scrollTo(String r100) {
        if (this.f218200web == null) goto L6;
        String r101 = String.format(Locale.ENGLISH, "window.lark.biz.navigation.jump", new Object[0]);
        JSONObject r102 = new JSONObject();
        r102.put2(faceverify.w.BLOB_ELEM_IMAGE_HASHCODE, r100);
        this.f218200web.j(r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setActive(String r100) {
        this.floatingActiveContentId = r100;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setContentScrollListener(a.InterfaceC3102a r100) {
        this.scrollListener = r100;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setContentTouchListener(View.OnTouchListener r100) {
        this.contentTouchListener = r100;
    }

    public void setFixMode(boolean r100) {
        this.fixMode = r100;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void setIsUpdateActiveByFixedStructure(boolean r100) {
        this.isUpdateActiveByFixedStructure = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setStructure(Structure r100) {
        MutableLiveData r101 = (MutableLiveData) getContent();
        boolean r102 = true;
        boolean r103 = !Structure.equals((Structure) r101.getValue(), r100);
        tt5.a.h(TAG, "setStructure diff?" + r103);
        if (r103 == false) goto L10;
        r101.setValue(r100);
        if (r100 == null) goto L8;
        r102 = false;
    L8:
        updateWebViewScrollBarStyle(r102);
        return;
    }

    public void setWeb(k r100) {
        this.f218200web = r100;
        r100.addOnTouchListener(this.contentTouchDispatcher);
        if ((r100 instanceof z4) == false) goto L6;
        ((z4) r100).d(this.scrollDispatchProxy);
        return;
    }

    private boolean dispatchContentTouch(View r100, MotionEvent r101) {
        Iterator<View.OnTouchListener> r102 = this.contentTouchListenerList.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        View.OnTouchListener r103 = r102.next();
        if (r103 == null) goto L4;
        r103.onTouch(r100, r101);
        goto L4
    L8:
        View.OnTouchListener r104 = this.contentTouchListener;
        if (r104 != null) goto L11;
    L13:
        return false;
    L11:
        if (r104.onTouch(r100, r101) == false) goto L13;
        return true;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void changeCollapseStatus(String r100, boolean r101) {
        String r102 = String.format(Locale.ENGLISH, "window.lark.biz.headings.switchHeading", new Object[0]);
        JSONObject r103 = new JSONObject();
        r103.put2(faceverify.w.BLOB_ELEM_IMAGE_HASHCODE, r100);
        r103.put2("status", Boolean.valueOf(r101));
        this.f218200web.j(r102, r103);
    }

    public void resetAnalytic(DocViewModel r100, d r101) {
        w r102 = this.structureAnalytic;
        r102.f516530a = r100;
        r102.f516531b = r101;
    }

    @Override // com.bytedance.ee.bear.doc.structure.a
    public void scrollTo(int r100, int r101) {
        k r102 = this.f218200web;
        if (r102 != null) goto L5;
        return;
    L5:
        WebView r103 = r102.getWebView();
        r103.startNestedScroll(2);
        if (r103.dispatchNestedPreScroll(0, r101 - r100, this.scrollConsumed, this.scrollOffset) == false) goto L8;
        r101 = r101 - this.scrollConsumed[1];
    L8:
        r103.stopNestedScroll();
        r103.scrollTo(0, r101);
    }

    private void dispatchScroll(View r100, int r101, int r102, int r103, int r104) {
        a.InterfaceC3102a r105 = this.scrollListener;
        if (r105 == null) goto L17;
        FloatingStructureFragment r106 = ((p) r105).f516523a;
        if (r106.f218169k.getVisibility() == 0) goto L10;
        if (r106.E == false) goto L10;
        tt5.a.b(r106.f218163e, "GestureListener onscroll invalid");
        r106.V90();
        j.e(r106.f218183y);
        j.d(r106.f218183y, 2000);
    L10:
        if (r106.f218165g.isFixMode() == true) goto L20;
        r106.ba0(r102);
        Structure r107 = r106.f218165g.getContent().getValue();
        if (r106.f218170l == true) goto L18;
        if (r107 == null) goto L19;
        j.e(r106.B);
        j.e(r106.f218183y);
        j.d(r106.f218183y, 2000);
        return;
    L19:
        return;
    L18:
        return;
    L20:
        return;
    }
}
