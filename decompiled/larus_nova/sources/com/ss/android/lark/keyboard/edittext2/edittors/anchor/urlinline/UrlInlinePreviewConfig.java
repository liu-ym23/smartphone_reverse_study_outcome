package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class UrlInlinePreviewConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f428993b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Source f428994a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig$Source;", "", "<init>", "(Ljava/lang/String;I)V", "URL_INLINE", "TEMP_PREVIEW", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source TEMP_PREVIEW = null;
        public static final Source URL_INLINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f428995a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f428996b = null;

        public static EnumEntries<Source> getEntries() {
            return f428996b;
        }

        static {
            Source r100 = new Source("URL_INLINE", 0);
            URL_INLINE = r100;
            Source r101 = new Source("TEMP_PREVIEW", 1);
            TEMP_PREVIEW = r101;
            Source[] r102 = {r100, r101};
            f428995a = r102;
            f428996b = EnumEntriesKt.enumEntries(r102);
        }

        public static Source[] values() {
            return (Source[]) f428995a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static UrlInlinePreviewConfig a() {
            return new UrlInlinePreviewConfig(Source.URL_INLINE);
        }
    }

    static {
    }

    public UrlInlinePreviewConfig(Source r100) {
        this.f428994a = r100;
    }
}
