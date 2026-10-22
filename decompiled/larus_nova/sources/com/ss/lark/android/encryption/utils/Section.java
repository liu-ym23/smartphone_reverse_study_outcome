package com.ss.lark.android.encryption.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/lark/android/encryption/utils/Section;", "", "length", "", "<init>", "(Ljava/lang/String;II)V", "getLength", "()I", "MAGIC_1", "DATA_OFFSET", "NONCE", "KEY_HASHER", "GAP_ZERO", "MAGIC_2", "UID", "DID", "VERSION", "RESERVED", "security-encryption_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum Section extends Enum<Section> {
    public static final Section DATA_OFFSET = null;
    public static final Section DID = null;
    public static final Section GAP_ZERO = null;
    public static final Section KEY_HASHER = null;
    public static final Section MAGIC_1 = null;
    public static final Section MAGIC_2 = null;
    public static final Section NONCE = null;
    public static final Section RESERVED = null;
    public static final Section UID = null;
    public static final Section VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Section[] f456824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f456825b = null;
    private final int length;

    public static EnumEntries<Section> getEntries() {
        return f456825b;
    }

    static {
        Section r100 = new Section("MAGIC_1", 0, 8);
        MAGIC_1 = r100;
        Section r101 = new Section("DATA_OFFSET", 1, 4);
        DATA_OFFSET = r101;
        Section r102 = new Section("NONCE", 2, 16);
        NONCE = r102;
        Section r103 = new Section("KEY_HASHER", 3, 16);
        KEY_HASHER = r103;
        Section r104 = new Section("GAP_ZERO", 4, 12);
        GAP_ZERO = r104;
        Section r110 = new Section("MAGIC_2", 5, 8);
        MAGIC_2 = r110;
        Section r111 = new Section("UID", 6, 8);
        UID = r111;
        Section r112 = new Section("DID", 7, 8);
        DID = r112;
        Section r113 = new Section("VERSION", 8, 1);
        VERSION = r113;
        Section r114 = new Section("RESERVED", 9, 15);
        RESERVED = r114;
        Section[] r105 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r114};
        f456824a = r105;
        f456825b = EnumEntriesKt.enumEntries(r105);
    }

    public static Section[] values() {
        return (Section[]) f456824a.clone();
    }

    public final int getLength() {
        return this.length;
    }

    public static Section valueOf(String r100) {
        return (Section) r27.a.a(Section.class, r100);
    }

    public Section(String r100, int r101, int r102) {
        super(r100, r101);
        this.length = r102;
    }
}
