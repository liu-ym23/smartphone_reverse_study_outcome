package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f414328a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIRecommendQuestions f414329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<?> f414330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f414331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f414332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.a f414333e;

        public a(AIRecommendQuestions r100, List<?> r101, boolean r102, boolean r103, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.a r104) {
            Intrinsics.checkNotNullParameter(r100, "summary");
            Intrinsics.checkNotNullParameter(r101, "messageList");
            this.f414329a = r100;
            this.f414330b = r101;
            this.f414331c = r102;
            this.f414332d = r103;
            this.f414333e = r104;
        }
    }

    public b() {
    }
}
