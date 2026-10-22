package com.ss.android.lark.vfs;

import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/vfs/Schemes;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FILE", "USF", "USF2", "ASSETS", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Schemes extends Enum<Schemes> {
    public static final Schemes ASSETS = null;
    public static final Schemes FILE = null;
    public static final Schemes USF = null;
    public static final Schemes USF2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Schemes[] f444815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444816b = null;
    private final String value;

    public static EnumEntries<Schemes> getEntries() {
        return f444816b;
    }

    static {
        Schemes r100 = new Schemes("FILE", 0, "file");
        FILE = r100;
        Schemes r101 = new Schemes("USF", 1, "usf");
        USF = r101;
        Schemes r102 = new Schemes("USF2", 2, "usf2");
        USF2 = r102;
        Schemes r103 = new Schemes("ASSETS", 3, ChameleonAssertResManager.ASSET_FOLDER);
        ASSETS = r103;
        Schemes[] r104 = {r100, r101, r102, r103};
        f444815a = r104;
        f444816b = EnumEntriesKt.enumEntries(r104);
    }

    public static Schemes[] values() {
        return (Schemes[]) f444815a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Schemes valueOf(String r100) {
        return (Schemes) r27.a.a(Schemes.class, r100);
    }

    public Schemes(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
