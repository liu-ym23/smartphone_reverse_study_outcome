package com.ss.android.lark.myai.export;

import android.os.Bundle;
import com.ss.android.lark.myai.export.model.ChatContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import osb.j;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.myai.export.a> f432875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ChatContext> f432876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f432877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f432878d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f432879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f432880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<com.ss.android.lark.myai.export.a> f432881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function0<ChatContext> f432882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f432883e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f432884f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<Object> f432885g;

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            this.f432879a = null;
            this.f432880b = new Bundle();
            this.f432881c = CollectionsKt.emptyList();
            this.f432882d = null;
            this.f432883e = null;
            this.f432884f = new ArrayList();
            this.f432885g = new ArrayList();
        }
    }

    public b(a r100) {
        r100.getClass();
        j r101 = r100.f432879a;
        if (r100.f432880b != null) goto L5;
        new Bundle();
    L5:
        this.f432875a = CollectionsKt.toList(r100.f432881c);
        this.f432876b = r100.f432882d;
        e r102 = r100.f432883e;
        this.f432877c = r100.f432884f;
        this.f432878d = CollectionsKt.toList(r100.f432885g);
    }
}
