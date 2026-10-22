package com.larus.avlink.plugins;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/avlink/plugins/CommandSendStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INITIALIZE", "DOUBAO_RECV", "DOUBAO_SEND", "DORA_SDK", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommandSendStatus extends Enum<CommandSendStatus> {
    public static final a Companion = null;
    public static final CommandSendStatus DORA_SDK = null;
    public static final CommandSendStatus DOUBAO_RECV = null;
    public static final CommandSendStatus DOUBAO_SEND = null;
    public static final CommandSendStatus INITIALIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommandSendStatus[] f293578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293579b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CommandSendStatus> getEntries() {
        return f293579b;
    }

    static {
        CommandSendStatus r100 = new CommandSendStatus("INITIALIZE", 0, "initialize");
        INITIALIZE = r100;
        CommandSendStatus r101 = new CommandSendStatus("DOUBAO_RECV", 1, "doubao_recv");
        DOUBAO_RECV = r101;
        CommandSendStatus r102 = new CommandSendStatus("DOUBAO_SEND", 2, "doubao_send");
        DOUBAO_SEND = r102;
        CommandSendStatus r103 = new CommandSendStatus("DORA_SDK", 3, MediaScene.DORA);
        DORA_SDK = r103;
        CommandSendStatus[] r104 = {r100, r101, r102, r103};
        f293578a = r104;
        f293579b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static CommandSendStatus[] values() {
        return (CommandSendStatus[]) f293578a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CommandSendStatus valueOf(String r100) {
        return (CommandSendStatus) r27.a.a(CommandSendStatus.class, r100);
    }

    public CommandSendStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
