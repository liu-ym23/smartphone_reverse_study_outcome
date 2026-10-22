package com.larus.dora.impl.noti_v3.social_message.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "", "titleResId", "", "<init>", "(Ljava/lang/String;II)V", "getTitleResId", "()I", "SINGLE", "GROUP", "RHYTHM", "CONFLICT", "toOptions", "", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeOption;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageModeSheetSource extends Enum<MessageModeSheetSource> {
    public static final MessageModeSheetSource CONFLICT = null;
    public static final a Companion = null;
    public static final MessageModeSheetSource GROUP = null;
    public static final MessageModeSheetSource RHYTHM = null;
    public static final MessageModeSheetSource SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageModeSheetSource[] f336470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336471b = null;
    private final int titleResId;

    public static final class a {
        public a() {
        }

        public static MessageModeSheetSource a(String r100) {
            MessageModeSheetSource[] r101 = MessageModeSheetSource.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            MessageModeSheetSource r104 = r101[r103];
            if (Intrinsics.areEqual(r104.name(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return MessageModeSheetSource.GROUP;
        L8:
            r104 = null;
            goto L9
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f336472a = null;

        static {
            int[] r100 = new int[MessageModeSheetSource.values().length];
            r100[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MessageModeSheetSource.RHYTHM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MessageModeSheetSource.CONFLICT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f336472a = r100;
        }
    }

    public static EnumEntries<MessageModeSheetSource> getEntries() {
        return f336471b;
    }

    static {
        MessageModeSheetSource r100 = new MessageModeSheetSource("SINGLE", 0, R.string.larus_dora_broadcast_v3_private_chat_title_cn);
        SINGLE = r100;
        MessageModeSheetSource r101 = new MessageModeSheetSource("GROUP", 1, R.string.larus_dora_broadcast_v3_group_chat_title_cn);
        GROUP = r101;
        MessageModeSheetSource r102 = new MessageModeSheetSource("RHYTHM", 2, R.string.larus_dora_broadcast_v3_frequency_title_cn);
        RHYTHM = r102;
        MessageModeSheetSource r103 = new MessageModeSheetSource("CONFLICT", 3, R.string.larus_dora_broadcast_v3_conflict_title_cn);
        CONFLICT = r103;
        MessageModeSheetSource[] r104 = {r100, r101, r102, r103};
        f336470a = r104;
        f336471b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MessageModeSheetSource[] values() {
        return (MessageModeSheetSource[]) f336470a.clone();
    }

    public final List<v59.a> toOptions() {
        int r100 = b.f336472a[ordinal()];
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L16;
        if (r100 != 4) goto L10;
        return CollectionsKt.listOf(new v59.a[]{new v59.a(R.string.larus_dora_broadcast_v3_conflict_mode_skip_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_conflict_mode_skip_desc_cn), "0"), new v59.a(R.string.larus_dora_broadcast_v3_conflict_mode_lower_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_conflict_mode_lower_desc_cn), "1")});
    L10:
        throw new NoWhenBranchMatchedException();
    L16:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(R.string.larus_dora_broadcast_v3_frequency_realtime_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_frequency_realtime_desc_cn), "3"), new v59.a(R.string.larus_dora_broadcast_v3_frequency_ten_seconds_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_frequency_ten_seconds_desc_cn), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ), new v59.a(R.string.larus_dora_broadcast_v3_frequency_thirty_seconds_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_frequency_thirty_seconds_desc_cn), BDLocationException.ERROR_SDK_NO_PERMISSION)});
    L17:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(R.string.larus_dora_broadcast_v3_social_mode_all_cn, null, "0"), new v59.a(R.string.larus_dora_broadcast_v3_social_mode_important_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_group_chat_important_desc_cn), "1"), new v59.a(R.string.larus_dora_broadcast_v3_social_mode_off_cn, null, "2")});
    L14:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(R.string.larus_dora_broadcast_v3_social_mode_all_cn, null, "0"), new v59.a(R.string.larus_dora_broadcast_v3_social_mode_important_cn, Integer.valueOf(R.string.larus_dora_broadcast_v3_private_chat_important_desc_cn), "1"), new v59.a(R.string.larus_dora_broadcast_v3_social_mode_off_cn, null, "2")});
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public static MessageModeSheetSource valueOf(String r100) {
        return (MessageModeSheetSource) r27.a.a(MessageModeSheetSource.class, r100);
    }

    public MessageModeSheetSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.titleResId = r102;
    }
}
