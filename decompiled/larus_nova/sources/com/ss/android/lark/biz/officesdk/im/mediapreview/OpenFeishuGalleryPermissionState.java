package com.ss.android.lark.biz.officesdk.im.mediapreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPermissionState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFeishuGalleryPermissionState extends Enum<OpenFeishuGalleryPermissionState> {
    public static final a Companion = null;
    public static final OpenFeishuGalleryPermissionState FINAL_AUTHORIZATION_STATE_DENY = null;
    public static final OpenFeishuGalleryPermissionState FINAL_AUTHORIZATION_STATE_PASS = null;
    public static final OpenFeishuGalleryPermissionState MIDDLE_AUTHORIZATION_STATE = null;
    public static final OpenFeishuGalleryPermissionState NORMAL_STATE = null;
    public static final OpenFeishuGalleryPermissionState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeishuGalleryPermissionState[] f410603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410604b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static OpenFeishuGalleryPermissionState a(int r100) {
            OpenFeishuGalleryPermissionState[] r101 = OpenFeishuGalleryPermissionState.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            OpenFeishuGalleryPermissionState r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return OpenFeishuGalleryPermissionState.UNKNOWN;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    @JvmStatic
    public static final OpenFeishuGalleryPermissionState fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<OpenFeishuGalleryPermissionState> getEntries() {
        return f410604b;
    }

    static {
        OpenFeishuGalleryPermissionState r100 = new OpenFeishuGalleryPermissionState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        OpenFeishuGalleryPermissionState r101 = new OpenFeishuGalleryPermissionState("MIDDLE_AUTHORIZATION_STATE", 1, 1);
        MIDDLE_AUTHORIZATION_STATE = r101;
        OpenFeishuGalleryPermissionState r102 = new OpenFeishuGalleryPermissionState("FINAL_AUTHORIZATION_STATE_PASS", 2, 2);
        FINAL_AUTHORIZATION_STATE_PASS = r102;
        OpenFeishuGalleryPermissionState r103 = new OpenFeishuGalleryPermissionState("FINAL_AUTHORIZATION_STATE_DENY", 3, 3);
        FINAL_AUTHORIZATION_STATE_DENY = r103;
        OpenFeishuGalleryPermissionState r104 = new OpenFeishuGalleryPermissionState("NORMAL_STATE", 4, 4);
        NORMAL_STATE = r104;
        OpenFeishuGalleryPermissionState[] r105 = {r100, r101, r102, r103, r104};
        f410603a = r105;
        f410604b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static OpenFeishuGalleryPermissionState[] values() {
        return (OpenFeishuGalleryPermissionState[]) f410603a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OpenFeishuGalleryPermissionState valueOf(String r100) {
        return (OpenFeishuGalleryPermissionState) r27.a.a(OpenFeishuGalleryPermissionState.class, r100);
    }

    public OpenFeishuGalleryPermissionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
