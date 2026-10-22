package com.ss.android.lark.blueprint;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public interface q<Data> {
    k a(IMMessageKeys$Blocks r100);

    View b(ViewGroup r100);

    <ViewType extends View, BlockViewType extends k<ViewType>> BlockViewType c(j r100, v r101, Function1<? super BlueprintLayoutInflater, ? extends BlockViewType> r102);

    k<?> f(j r100, v r101);

    void l(Data r100);

    k<?> o(j r100, v r101);

    void update(Data r100);
}
