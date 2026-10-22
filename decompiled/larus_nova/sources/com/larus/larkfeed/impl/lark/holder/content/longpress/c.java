package com.larus.larkfeed.impl.lark.holder.content.longpress;

import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final df8.a f355376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f355377b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f355376a, r101.f355376a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f355377b, r101.f355377b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            df8.a r100 = this.f355376a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.f355377b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "CreationImage(imageItemInfo=" + this.f355376a + ", extraParams=" + this.f355377b + ')';
        }

        public a(df8.a r100, JSONObject r101) {
            this.f355376a = r100;
            this.f355377b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AiGenVideoContentData f355378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f355379b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f355378a, r101.f355378a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f355379b, r101.f355379b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            AiGenVideoContentData r100 = this.f355378a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.f355379b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "CreationVideo(videoContent=" + this.f355378a + ", extraParams=" + this.f355379b + ')';
        }

        public b(AiGenVideoContentData r100, JSONObject r101) {
            this.f355378a = r100;
            this.f355379b = r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.larkfeed.impl.lark.holder.content.longpress.c$c, reason: collision with other inner class name */
    public static final class C4398c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LongClickSource f355380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f355381b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4398c) == true) goto L8;
            return false;
        L8:
            C4398c r101 = (C4398c) r100;
            if (this.f355380a == r101.f355380a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f355381b, r101.f355381b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f355380a.hashCode() * 31;
            Message r101 = this.f355381b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Text(longClickSource=" + this.f355380a + ", message=" + this.f355381b + ')';
        }

        public C4398c(LongClickSource r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "longClickSource");
            this.f355380a = r100;
            this.f355381b = r101;
        }
    }

    public c() {
    }
}
