package com.bytedance.ee.bear.content.creation.mvp;

import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void j7(SelectCreationMenuItem.ItemType r1);
    }

    void o1(ArrayList<SelectCreationMenuItem> r1, ArrayList<SelectCreationMenuItem> r2);

    void v6(boolean r1);
}
