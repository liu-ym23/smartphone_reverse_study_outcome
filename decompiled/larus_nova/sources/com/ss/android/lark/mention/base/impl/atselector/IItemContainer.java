package com.ss.android.lark.mention.base.impl.atselector;

import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface IItemContainer {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectMode {
        public static final int MULTI = 1;
        public static final int SINGLE = 0;
    }

    public interface a {
        void a(BaseAtBean r100);

        void b(BaseAtBean r100);

        void c(BaseAtBean r100);
    }

    a a0();

    int getItemCount();

    List<BaseAtBean> getItems();

    int y0();
}
