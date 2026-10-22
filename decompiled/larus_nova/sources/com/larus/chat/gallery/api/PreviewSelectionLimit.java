package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class PreviewSelectionLimit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f324114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaScope f324115b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewSelectionLimit$MediaScope;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ONLY", "IMAGE_AND_VIDEO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MediaScope extends Enum<MediaScope> {
        public static final MediaScope IMAGE_AND_VIDEO = null;
        public static final MediaScope IMAGE_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaScope[] f324116a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f324117b = null;

        public static EnumEntries<MediaScope> getEntries() {
            return f324117b;
        }

        static {
            MediaScope r100 = new MediaScope("IMAGE_ONLY", 0);
            IMAGE_ONLY = r100;
            MediaScope r101 = new MediaScope("IMAGE_AND_VIDEO", 1);
            IMAGE_AND_VIDEO = r101;
            MediaScope[] r102 = {r100, r101};
            f324116a = r102;
            f324117b = EnumEntriesKt.enumEntries(r102);
        }

        public static MediaScope[] values() {
            return (MediaScope[]) f324116a.clone();
        }

        public static MediaScope valueOf(String r100) {
            return (MediaScope) r27.a.a(MediaScope.class, r100);
        }

        public MediaScope(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewSelectionLimit) == true) goto L8;
        return false;
    L8:
        PreviewSelectionLimit r101 = (PreviewSelectionLimit) r100;
        if (this.f324114a == r101.f324114a) goto L12;
        return false;
    L12:
        if (this.f324115b == r101.f324115b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f324114a * 31) + this.f324115b.hashCode();
    }

    public final String toString() {
        return "PreviewSelectionLimit(maxCount=" + this.f324114a + ", mediaScope=" + this.f324115b + ')';
    }

    public PreviewSelectionLimit(int r100, MediaScope r101) {
        Intrinsics.checkNotNullParameter(r101, "mediaScope");
        this.f324114a = r100;
        this.f324115b = r101;
    }
}
