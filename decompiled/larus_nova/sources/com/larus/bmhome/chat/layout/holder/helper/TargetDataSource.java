package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/helper/TargetDataSource;", "", PickerReporterConstants.KEY.TARGET, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTarget", "()Ljava/lang/String;", AccountType.ALL, "Thinking", "Content", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TargetDataSource extends Enum<TargetDataSource> {
    public static final TargetDataSource ALL = null;
    public static final TargetDataSource Content = null;
    public static final TargetDataSource Thinking = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TargetDataSource[] f303567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303568b = null;
    private final String target;

    public static EnumEntries<TargetDataSource> getEntries() {
        return f303568b;
    }

    static {
        TargetDataSource r100 = new TargetDataSource(AccountType.ALL, 0, "all");
        ALL = r100;
        TargetDataSource r101 = new TargetDataSource("Thinking", 1, SubtitleListUpdateType.THINKING);
        Thinking = r101;
        TargetDataSource r102 = new TargetDataSource("Content", 2, "content");
        Content = r102;
        TargetDataSource[] r103 = {r100, r101, r102};
        f303567a = r103;
        f303568b = EnumEntriesKt.enumEntries(r103);
    }

    public static TargetDataSource[] values() {
        return (TargetDataSource[]) f303567a.clone();
    }

    public final String getTarget() {
        return this.target;
    }

    public static TargetDataSource valueOf(String r100) {
        return (TargetDataSource) r27.a.a(TargetDataSource.class, r100);
    }

    public TargetDataSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.target = r102;
    }
}
