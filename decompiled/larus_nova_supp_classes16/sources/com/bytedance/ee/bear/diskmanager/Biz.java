package com.bytedance.ee.bear.diskmanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/diskmanager/Biz;", "", "bizRootDir", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizRootDir", "()Ljava/lang/String;", "DRIVE", "DOCS", "RUSTSDK", "LOG", "DYNAMIC", "DISK_CACHE_DIR", "base-diskmanager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Biz extends Enum<Biz> {
    public static final Biz DISK_CACHE_DIR = null;
    public static final Biz DOCS = null;
    public static final Biz DRIVE = null;
    public static final Biz DYNAMIC = null;
    public static final Biz LOG = null;
    public static final Biz RUSTSDK = null;
    public static final /* synthetic */ Biz[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String bizRootDir;

    public static EnumEntries<Biz> getEntries() {
        return b;
    }

    static {
        Biz r0 = new Biz("DRIVE", 0, "drive");
        DRIVE = r0;
        Biz r1 = new Biz("DOCS", 1, "docs");
        DOCS = r1;
        Biz r2 = new Biz("RUSTSDK", 2, "rustsdk");
        RUSTSDK = r2;
        Biz r4 = new Biz("LOG", 3, "log");
        LOG = r4;
        Biz r6 = new Biz("DYNAMIC", 4, "dynamic");
        DYNAMIC = r6;
        Biz r8 = new Biz("DISK_CACHE_DIR", 5, "luban_disk_cache");
        DISK_CACHE_DIR = r8;
        Biz[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static Biz[] values() {
        return (Biz[]) a.clone();
    }

    public final String getBizRootDir() {
        return this.bizRootDir;
    }

    public static Biz valueOf(String r1) {
        return (Biz) a.a(Biz.class, r1);
    }

    public Biz(String r1, int r2, String r3) {
        super(r1, r2);
        this.bizRootDir = r3;
    }
}
