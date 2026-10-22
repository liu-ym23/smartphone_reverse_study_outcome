package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourcePhase;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "VALIDATE", "REMOTE_RESOLVE", "POLICY", "PREPROCESS", "DETECT", "UPLOAD", "REMOTE_DIRECT", "REVIEW", "POST_PROCESS", "CACHE", "REMOTE_FALLBACK", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourcePhase extends Enum<ResourcePhase> {
    public static final ResourcePhase CACHE = null;
    public static final ResourcePhase DETECT = null;
    public static final ResourcePhase POLICY = null;
    public static final ResourcePhase POST_PROCESS = null;
    public static final ResourcePhase PREPROCESS = null;
    public static final ResourcePhase REMOTE_DIRECT = null;
    public static final ResourcePhase REMOTE_FALLBACK = null;
    public static final ResourcePhase REMOTE_RESOLVE = null;
    public static final ResourcePhase REVIEW = null;
    public static final ResourcePhase UPLOAD = null;
    public static final ResourcePhase VALIDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourcePhase[] f313587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313588b = null;
    private final int order;

    public static EnumEntries<ResourcePhase> getEntries() {
        return f313588b;
    }

    static {
        ResourcePhase r100 = new ResourcePhase("VALIDATE", 0, 10);
        VALIDATE = r100;
        ResourcePhase r101 = new ResourcePhase("REMOTE_RESOLVE", 1, 15);
        REMOTE_RESOLVE = r101;
        ResourcePhase r102 = new ResourcePhase("POLICY", 2, 18);
        POLICY = r102;
        ResourcePhase r103 = new ResourcePhase("PREPROCESS", 3, 20);
        PREPROCESS = r103;
        ResourcePhase r104 = new ResourcePhase("DETECT", 4, 30);
        DETECT = r104;
        ResourcePhase r105 = new ResourcePhase("UPLOAD", 5, 40);
        UPLOAD = r105;
        ResourcePhase r110 = new ResourcePhase("REMOTE_DIRECT", 6, 45);
        REMOTE_DIRECT = r110;
        ResourcePhase r111 = new ResourcePhase("REVIEW", 7, 50);
        REVIEW = r111;
        ResourcePhase r112 = new ResourcePhase("POST_PROCESS", 8, 60);
        POST_PROCESS = r112;
        ResourcePhase r113 = new ResourcePhase("CACHE", 9, 70);
        CACHE = r113;
        ResourcePhase r114 = new ResourcePhase("REMOTE_FALLBACK", 10, 80);
        REMOTE_FALLBACK = r114;
        ResourcePhase[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f313587a = r106;
        f313588b = EnumEntriesKt.enumEntries(r106);
    }

    public static ResourcePhase[] values() {
        return (ResourcePhase[]) f313587a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static ResourcePhase valueOf(String r100) {
        return (ResourcePhase) r27.a.a(ResourcePhase.class, r100);
    }

    public ResourcePhase(String r100, int r101, int r102) {
        super(r100, r101);
        this.order = r102;
    }
}
