package com.larus.livetutor.impl.history;

import com.larus.livetutor.api.idl.FlashCardRecord;
import com.larus.livetutor.api.idl.LiveTutorRecord;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f356050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f356051b;

    public static final class a {
    }

    public static final class b extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FlashCardRecord f356052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f356053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f356054e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356052c, ((b) r100).f356052c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356052c.hashCode();
        }

        public final String toString() {
            return "FlashCardType(flashCardRecord=" + this.f356052c + ')';
        }

        @Override // com.larus.livetutor.impl.history.v
        public final Long a() {
            return this.f356054e;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final FlashCardRecord b() {
            return this.f356052c;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final int d() {
            return this.f356053d;
        }

        public b(FlashCardRecord r100) {
            Intrinsics.checkNotNullParameter(r100, "flashCardRecord");
            this.f356052c = r100;
            this.f356053d = 1005;
            this.f356054e = r100.getCreatedTime();
        }
    }

    public static final class c extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LiveTutorRecord f356055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f356056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f356057e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356055c, ((c) r100).f356055c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356055c.hashCode();
        }

        public final String toString() {
            return "ImageType(record=" + this.f356055c + ')';
        }

        @Override // com.larus.livetutor.impl.history.v
        public final Long a() {
            return this.f356057e;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final LiveTutorRecord c() {
            return this.f356055c;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final int d() {
            return this.f356056d;
        }

        public c(LiveTutorRecord r100) {
            Intrinsics.checkNotNullParameter(r100, "record");
            this.f356055c = r100;
            this.f356056d = 1001;
            this.f356057e = r100.getCreatedTime();
        }
    }

    public static final class d extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LiveTutorRecord f356058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f356059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f356060e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356058c, ((d) r100).f356058c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356058c.hashCode();
        }

        public final String toString() {
            return "TextType(record=" + this.f356058c + ')';
        }

        @Override // com.larus.livetutor.impl.history.v
        public final Long a() {
            return this.f356060e;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final LiveTutorRecord c() {
            return this.f356058c;
        }

        @Override // com.larus.livetutor.impl.history.v
        public final int d() {
            return this.f356059d;
        }

        public d(LiveTutorRecord r100) {
            Intrinsics.checkNotNullParameter(r100, "record");
            this.f356058c = r100;
            this.f356059d = 1002;
            this.f356060e = r100.getCreatedTime();
        }
    }

    public static final class e extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f356061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f356062d;

        @Override // com.larus.livetutor.impl.history.v
        public final Long a() {
            return null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356061c, ((e) r100).f356061c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356061c.hashCode();
        }

        public final String toString() {
            return "TimeType(timeText=" + this.f356061c + ')';
        }

        @Override // com.larus.livetutor.impl.history.v
        public final int d() {
            return this.f356062d;
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "timeText");
            this.f356061c = r100;
            this.f356062d = 1003;
        }
    }

    static {
    }

    public abstract Long a();

    public FlashCardRecord b() {
        return null;
    }

    public LiveTutorRecord c() {
        return null;
    }

    public abstract int d();

    public v() {
        this.f356050a = 1;
        this.f356051b = 1;
    }
}
