package com.larus.platform.model;

import com.obric.miniapp.alarm.AccountType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/UploadUiStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.LOCAL, "LOCAL_DRIVE", "LOCAL_DRIVE_RECENT", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadUiStyle extends Enum<UploadUiStyle> {
    public static final a Companion = null;
    public static final UploadUiStyle LOCAL = null;
    public static final UploadUiStyle LOCAL_DRIVE = null;
    public static final UploadUiStyle LOCAL_DRIVE_RECENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadUiStyle[] f365498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365499b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static UploadUiStyle a(int r100) {
            Iterator<UploadUiStyle> r101 = UploadUiStyle.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            UploadUiStyle r102 = r101.next();
            if (r102.getValue() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L12:
            UploadUiStyle r104 = r102;
            if (r104 == null) goto L15;
            return r104;
        L15:
            return UploadUiStyle.LOCAL;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L12
        }
    }

    public static EnumEntries<UploadUiStyle> getEntries() {
        return f365499b;
    }

    static {
        UploadUiStyle r100 = new UploadUiStyle(AccountType.LOCAL, 0, 0);
        LOCAL = r100;
        UploadUiStyle r101 = new UploadUiStyle("LOCAL_DRIVE", 1, 1);
        LOCAL_DRIVE = r101;
        UploadUiStyle r102 = new UploadUiStyle("LOCAL_DRIVE_RECENT", 2, 2);
        LOCAL_DRIVE_RECENT = r102;
        UploadUiStyle[] r103 = {r100, r101, r102};
        f365498a = r103;
        f365499b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static UploadUiStyle[] values() {
        return (UploadUiStyle[]) f365498a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UploadUiStyle valueOf(String r100) {
        return (UploadUiStyle) r27.a.a(UploadUiStyle.class, r100);
    }

    public UploadUiStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
