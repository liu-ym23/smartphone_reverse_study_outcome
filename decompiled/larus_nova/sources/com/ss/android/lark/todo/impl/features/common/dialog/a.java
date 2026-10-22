package com.ss.android.lark.todo.impl.features.common.dialog;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SectionHeaderItem> f442422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC5342a f442423b;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.common.dialog.a$a, reason: collision with other inner class name */
    public interface InterfaceC5342a {
        void a();

        void b();

        void c();

        void d(List<String> r100, Map<String, String> r101);
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f442422a = CollectionsKt.emptyList();
        gravity(80);
    }
}
