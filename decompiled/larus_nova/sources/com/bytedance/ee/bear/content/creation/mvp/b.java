package com.bytedance.ee.bear.content.creation.mvp;

import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void j7(SelectCreationMenuItem.ItemType r100);
    }

    void o1(ArrayList<SelectCreationMenuItem> r100, ArrayList<SelectCreationMenuItem> r101);

    void v6(boolean r100);
}
