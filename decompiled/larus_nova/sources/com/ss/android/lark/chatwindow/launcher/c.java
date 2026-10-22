package com.ss.android.lark.chatwindow.launcher;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f416976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Chat f416977b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f416976a, r101.f416976a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f416977b, r101.f416977b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f416976a.hashCode() * 31;
            Chat r101 = this.f416977b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChatWrapper(chatId=" + this.f416976a + ", chat=" + this.f416977b + ')';
        }

        public a(String r100, Chat r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            this.f416976a = r100;
            this.f416977b = r101;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f416978a;

            public a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "errorMsg");
                this.f416978a = r100;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.launcher.c$b$b, reason: collision with other inner class name */
        public static final class C4880b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f416979a;

            public C4880b(a r100) {
                Intrinsics.checkNotNullParameter(r100, "chat");
                this.f416979a = r100;
            }
        }

        public b() {
        }
    }

    void U7(Context r100, Fragment r101, ChatBundleInput r102, IGetDataCallback<Unit> r103);
}
