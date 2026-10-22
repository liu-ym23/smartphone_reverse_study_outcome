package com.ss.android.lark.export.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/export/entity/SendScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DOUBAO_CLOUD_DRIVE_CHOOSE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendScene extends Enum<SendScene> {
    public static final a Companion = null;
    public static final SendScene DEFAULT = null;
    public static final SendScene DOUBAO_CLOUD_DRIVE_CHOOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendScene[] f420654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420655b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SendScene> getEntries() {
        return f420655b;
    }

    static {
        SendScene r100 = new SendScene("DEFAULT", 0, 0);
        DEFAULT = r100;
        SendScene r101 = new SendScene("DOUBAO_CLOUD_DRIVE_CHOOSE", 1, 1);
        DOUBAO_CLOUD_DRIVE_CHOOSE = r101;
        SendScene[] r102 = {r100, r101};
        f420654a = r102;
        f420655b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static SendScene[] values() {
        return (SendScene[]) f420654a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SendScene valueOf(String r100) {
        return (SendScene) r27.a.a(SendScene.class, r100);
    }

    public SendScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
