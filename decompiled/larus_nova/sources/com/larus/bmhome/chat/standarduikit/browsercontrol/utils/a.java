package com.larus.bmhome.chat.standarduikit.browsercontrol.utils;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308923a = 0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a$a, reason: collision with other inner class name */
    public static final class C4071a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f308924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f308925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f308926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f308927d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4071a) == true) goto L8;
            return false;
        L8:
            C4071a r101 = (C4071a) r100;
            if (Intrinsics.areEqual(this.f308924a, r101.f308924a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f308925b, r101.f308925b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f308926c, r101.f308926c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f308927d, r101.f308927d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f308924a.hashCode() * 31;
            Integer r101 = this.f308925b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f308926c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f308927d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "TrackParams(blockId=" + this.f308924a + ", interactionType=" + this.f308925b + ", displayType=" + this.f308926c + ", agentType=" + this.f308927d + ')';
        }

        public C4071a(String r100, Integer r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
            this.f308924a = r100;
            this.f308925b = r101;
            this.f308926c = r102;
            this.f308927d = r103;
        }
    }

    static {
    }
}
