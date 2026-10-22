package com.ss.android.lark.chat.service.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b2 {

    public static final class a extends b2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f416452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f416453b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f416452a, r101.f416452a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f416453b, r101.f416453b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f416452a.hashCode() * 31;
            String r101 = this.f416453b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChatInput(chatId=" + this.f416452a + ", draftId=" + this.f416453b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            this.f416452a = r100;
            this.f416453b = r101;
        }
    }

    public b2() {
    }
}
