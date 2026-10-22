package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ServiceBotCardHelper$onLongPress$messageAnchor$1$1 extends FunctionReferenceImpl implements Function1<Integer, View> {
    public ServiceBotCardHelper$onLongPress$messageAnchor$1$1(Object r100) {
        super(1, r100, RecyclerView.class, "getChildAt", "getChildAt(I)Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final View invoke(int r100) {
        return ((RecyclerView) this.receiver).getChildAt(r100);
    }
}
