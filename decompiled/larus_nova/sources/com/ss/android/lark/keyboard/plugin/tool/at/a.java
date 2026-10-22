package com.ss.android.lark.keyboard.plugin.tool.at;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.at.a$a, reason: collision with other inner class name */
    public static final class C5105a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f429623d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f429624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<UserGroupEntity> f429625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f429626c;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.at.a$a$a, reason: collision with other inner class name */
        public static final class C5106a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5105a) == true) goto L8;
            return false;
        L8:
            C5105a r101 = (C5105a) r100;
            if (Intrinsics.areEqual(this.f429624a, r101.f429624a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f429625b, r101.f429625b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f429626c, r101.f429626c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f429624a.hashCode() * 31) + this.f429625b.hashCode()) * 31) + this.f429626c.hashCode();
        }

        public final String toString() {
            return "AtSelectorResult(chatterInfo=" + this.f429624a + ", userGroupInfo=" + this.f429625b + ", wikiInfo=" + this.f429626c + ')';
        }

        public C5105a(List<b> r100, List<UserGroupEntity> r101, List<c> r102) {
            Intrinsics.checkNotNullParameter(r100, "chatterInfo");
            Intrinsics.checkNotNullParameter(r101, "userGroupInfo");
            Intrinsics.checkNotNullParameter(r102, "wikiInfo");
            this.f429624a = r100;
            this.f429625b = r101;
            this.f429626c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f429627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Chatter.ChatterType f429628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f429629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f429630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f429631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f429632f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f429627a, r101.f429627a) == true) goto L12;
            return false;
        L12:
            if (this.f429628b == r101.f429628b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f429629c, r101.f429629c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f429630d, r101.f429630d) == true) goto L21;
            return false;
        L21:
            if (this.f429631e == r101.f429631e) goto L24;
            return false;
        L24:
            if (this.f429632f == r101.f429632f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f429627a.hashCode() * 31;
            Chatter.ChatterType r101 = this.f429628b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (((((r100 + r102) * 31) + this.f429629c.hashCode()) * 31) + this.f429630d.hashCode()) * 31;
            int r104 = 1231;
            if (this.f429631e == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f429632f == true) goto L15;
            r104 = 1237;
        L15:
            return r106 + r104;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatterId=" + this.f429627a + ", chatterType=" + this.f429628b + ", displayName=" + this.f429629c + ", originName=" + this.f429630d + ", isOutChatUser=" + this.f429631e + ", isAnonymous=" + this.f429632f + ')';
        }

        public b(String r100, Chatter.ChatterType r101, String r102, String r103, boolean r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r100, "chatterId");
            Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
            Intrinsics.checkNotNullParameter(r103, "originName");
            this.f429627a = r100;
            this.f429628b = r101;
            this.f429629c = r102;
            this.f429630d = r103;
            this.f429631e = r104;
            this.f429632f = r105;
        }
    }

    public static final class c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "WikiInfo(url=null, title=null, localIconRes=null)";
        }
    }

    int a(String r100, boolean r101);

    void b(EditText r100, b r101);

    String c();

    boolean d(boolean r100, boolean r101);

    void e(boolean r100, com.ss.android.lark.keyboard.b r101, Bundle r102);

    AtomicBoolean f();

    C5105a g(Intent r100);

    void h(String r100);
}
