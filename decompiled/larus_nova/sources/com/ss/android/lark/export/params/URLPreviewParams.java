package com.ss.android.lark.export.params;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import vcb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class URLPreviewParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f420685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f420686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f420687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f420688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f420689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f420690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f420691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f420692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f420693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f420694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f420695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f420696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f420697m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/export/params/URLPreviewParams$SourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MyAIDialog", "Chat", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType Chat = null;
        public static final a Companion = null;
        public static final SourceType MyAIDialog = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SourceType[] f420698a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420699b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<SourceType> getEntries() {
            return f420699b;
        }

        static {
            SourceType r100 = new SourceType("MyAIDialog", 0, 0);
            MyAIDialog = r100;
            SourceType r101 = new SourceType("Chat", 1, 1);
            Chat = r101;
            SourceType[] r102 = {r100, r101};
            f420698a = r102;
            f420699b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static SourceType[] values() {
            return (SourceType[]) f420698a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) r27.a.a(SourceType.class, r100);
        }

        public SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f420700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f420701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f420702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f420703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, ? extends Object> f420704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f420705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f420706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f420707h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Long f420708i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Long f420709j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Boolean f420710k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f420711l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public b f420712m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f420713n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f420714o;

        public a() {
            this.f420700a = "";
            this.f420703d = true;
            this.f420704e = new LinkedHashMap();
            this.f420706g = "";
            this.f420707h = "";
            this.f420708i = 0L;
            this.f420709j = 0L;
            this.f420710k = Boolean.FALSE;
            SourceType.a r100 = SourceType.Companion;
        }
    }

    public URLPreviewParams(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f420685a = r100.f420700a;
        this.f420686b = r100.f420701b;
        this.f420687c = r100.f420702c;
        this.f420688d = r100.f420703d;
        this.f420689e = r100.f420704e;
        this.f420690f = r100.f420705f;
        String r101 = r100.f420706g;
        this.f420691g = r100.f420707h;
        this.f420692h = r100.f420708i;
        this.f420693i = r100.f420709j;
        this.f420694j = r100.f420710k;
        this.f420695k = r100.f420711l;
        b r102 = r100.f420712m;
        this.f420696l = r100.f420714o;
        this.f420697m = r100.f420713n;
    }
}
