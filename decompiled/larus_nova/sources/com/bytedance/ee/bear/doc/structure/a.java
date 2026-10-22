package com.bytedance.ee.bear.doc.structure;

import android.view.View;
import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes16.dex */
public interface a<Content> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.structure.a$a, reason: collision with other inner class name */
    public interface InterfaceC3102a {
    }

    void changeCollapseStatus(String r100, boolean r101);

    int computeContentHeight();

    String getActive();

    LiveData<Content> getContent();

    int getContentHeight();

    int getContentScroll();

    boolean isUpdateActiveByFixedStructure();

    void scrollTo(int r100, int r101);

    void scrollTo(String r100);

    void setActive(String r100);

    void setContentScrollListener(InterfaceC3102a r100);

    void setContentTouchListener(View.OnTouchListener r100);

    void setIsUpdateActiveByFixedStructure(boolean r100);
}
