package com.larus.dora.impl.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/model/GestureSettingsKey;", "", "role", "", "status", "key", "<init>", "(Ljava/lang/String;IBBB)V", "getRole", "()B", "getStatus", "getKey", "MEDIA_LEFT_DOUBLE_CLICK", "MEDIA_RIGHT_DOUBLE_CLICK", "CALLING_LEFT_DOUBLE_CLICK", "CALLING_RIGHT_DOUBLE_CLICK", "normalize", "", "toByteArray", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GestureSettingsKey extends Enum<GestureSettingsKey> {
    public static final GestureSettingsKey CALLING_LEFT_DOUBLE_CLICK = null;
    public static final GestureSettingsKey CALLING_RIGHT_DOUBLE_CLICK = null;
    public static final a Companion = null;
    public static final GestureSettingsKey MEDIA_LEFT_DOUBLE_CLICK = null;
    public static final GestureSettingsKey MEDIA_RIGHT_DOUBLE_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureSettingsKey[] f336152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336153b = null;
    private final byte key;
    private final byte role;
    private final byte status;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GestureSettingsKey> getEntries() {
        return f336153b;
    }

    public final byte[] toByteArray() {
        return new byte[]{this.role, this.status, this.key};
    }

    static {
        GestureSettingsKey r100 = new GestureSettingsKey("MEDIA_LEFT_DOUBLE_CLICK", 0, (byte) 16, (byte) 0);
        MEDIA_LEFT_DOUBLE_CLICK = r100;
        GestureSettingsKey r101 = new GestureSettingsKey("MEDIA_RIGHT_DOUBLE_CLICK", 1, (byte) 0, (byte) 0);
        MEDIA_RIGHT_DOUBLE_CLICK = r101;
        GestureSettingsKey r102 = new GestureSettingsKey("CALLING_LEFT_DOUBLE_CLICK", 2, (byte) 16, (byte) 1);
        CALLING_LEFT_DOUBLE_CLICK = r102;
        GestureSettingsKey r103 = new GestureSettingsKey("CALLING_RIGHT_DOUBLE_CLICK", 3, (byte) 0, (byte) 1);
        CALLING_RIGHT_DOUBLE_CLICK = r103;
        GestureSettingsKey[] r104 = {r100, r101, r102, r103};
        f336152a = r104;
        f336153b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static GestureSettingsKey[] values() {
        return (GestureSettingsKey[]) f336152a.clone();
    }

    public final String normalize() {
        return this.role + ", " + this.status + ", " + this.key;
    }

    public final byte getKey() {
        return this.key;
    }

    public final byte getRole() {
        return this.role;
    }

    public final byte getStatus() {
        return this.status;
    }

    public static GestureSettingsKey valueOf(String r100) {
        return (GestureSettingsKey) r27.a.a(GestureSettingsKey.class, r100);
    }

    public GestureSettingsKey(String r100, int r101, byte r102, byte r103) {
        super(r100, r101);
        this.role = r102;
        this.status = r103;
        this.key = 1;
    }
}
