package com.ss.android.lark.keyboard.dtocompat;

import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class UrlInlinePreviewEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f428709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f428710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f428711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f428712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f428713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f428714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f428715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f428716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f428717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f428718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f428719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f428720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinkType f428721n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity$UrlPreViewSourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "CHAT_ANNOUNCEMENT", "PERSONAL_SIG", "PRIVATE_DESCRIPTION", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UrlPreViewSourceType extends Enum<UrlPreViewSourceType> {
        public static final UrlPreViewSourceType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final UrlPreViewSourceType PERSONAL_SIG = null;
        public static final UrlPreViewSourceType PRIVATE_DESCRIPTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UrlPreViewSourceType[] f428722a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f428723b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<UrlPreViewSourceType> getEntries() {
            return f428723b;
        }

        static {
            UrlPreViewSourceType r100 = new UrlPreViewSourceType("CHAT_ANNOUNCEMENT", 0, 1);
            CHAT_ANNOUNCEMENT = r100;
            UrlPreViewSourceType r101 = new UrlPreViewSourceType("PERSONAL_SIG", 1, 10);
            PERSONAL_SIG = r101;
            UrlPreViewSourceType r102 = new UrlPreViewSourceType("PRIVATE_DESCRIPTION", 2, 11);
            PRIVATE_DESCRIPTION = r102;
            UrlPreViewSourceType[] r103 = {r100, r101, r102};
            f428722a = r103;
            f428723b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static UrlPreViewSourceType[] values() {
            return (UrlPreViewSourceType[]) f428722a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UrlPreViewSourceType valueOf(String r100) {
            return (UrlPreViewSourceType) r27.a.a(UrlPreViewSourceType.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public UrlPreViewSourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public UrlInlinePreviewEntity(String r100, String r101, String r102, int r103, int r104, String r105, String r106, int r110, int r111, String r112, String r113, int r114, boolean r115) {
        LinkType r107 = LinkType.UrlInline;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "iconKey");
        this.f428708a = r100;
        this.f428709b = r101;
        this.f428710c = r102;
        this.f428711d = r103;
        this.f428712e = r104;
        this.f428713f = r105;
        this.f428714g = r106;
        this.f428715h = r110;
        this.f428716i = r111;
        this.f428717j = r112;
        this.f428718k = r113;
        this.f428719l = r114;
        this.f428720m = r115;
        this.f428721n = r107;
    }
}
