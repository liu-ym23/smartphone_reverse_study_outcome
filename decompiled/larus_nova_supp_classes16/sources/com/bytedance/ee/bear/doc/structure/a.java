package com.bytedance.ee.bear.doc.structure;

import android.view.View;
import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a<Content> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.structure.a$a, reason: collision with other inner class name */
    public interface InterfaceC0046a {
    }

    void changeCollapseStatus(String r1, boolean r2);

    int computeContentHeight();

    String getActive();

    LiveData<Content> getContent();

    int getContentHeight();

    int getContentScroll();

    boolean isUpdateActiveByFixedStructure();

    void scrollTo(int r1, int r2);

    void scrollTo(String r1);

    void setActive(String r1);

    void setContentScrollListener(InterfaceC0046a r1);

    void setContentTouchListener(View.OnTouchListener r1);

    void setIsUpdateActiveByFixedStructure(boolean r1);
}
