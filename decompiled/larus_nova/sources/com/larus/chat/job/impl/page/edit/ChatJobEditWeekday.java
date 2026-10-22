package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditWeekday;", "", "<init>", "(Ljava/lang/String;I)V", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "label", "", "getLabel", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatJobEditWeekday extends Enum<ChatJobEditWeekday> {
    public static final ChatJobEditWeekday FRIDAY = null;
    public static final ChatJobEditWeekday MONDAY = null;
    public static final ChatJobEditWeekday SATURDAY = null;
    public static final ChatJobEditWeekday SUNDAY = null;
    public static final ChatJobEditWeekday THURSDAY = null;
    public static final ChatJobEditWeekday TUESDAY = null;
    public static final ChatJobEditWeekday WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatJobEditWeekday[] f325221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325222b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f325223a = null;

        static {
            int[] r100 = new int[ChatJobEditWeekday.values().length];
            r100[ChatJobEditWeekday.SUNDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ChatJobEditWeekday.MONDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ChatJobEditWeekday.TUESDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ChatJobEditWeekday.WEDNESDAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ChatJobEditWeekday.THURSDAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ChatJobEditWeekday.FRIDAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ChatJobEditWeekday.SATURDAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f325223a = r100;
        }
    }

    public static EnumEntries<ChatJobEditWeekday> getEntries() {
        return f325222b;
    }

    static {
        ChatJobEditWeekday r100 = new ChatJobEditWeekday("SUNDAY", 0);
        SUNDAY = r100;
        ChatJobEditWeekday r101 = new ChatJobEditWeekday("MONDAY", 1);
        MONDAY = r101;
        ChatJobEditWeekday r102 = new ChatJobEditWeekday("TUESDAY", 2);
        TUESDAY = r102;
        ChatJobEditWeekday r103 = new ChatJobEditWeekday("WEDNESDAY", 3);
        WEDNESDAY = r103;
        ChatJobEditWeekday r104 = new ChatJobEditWeekday("THURSDAY", 4);
        THURSDAY = r104;
        ChatJobEditWeekday r105 = new ChatJobEditWeekday("FRIDAY", 5);
        FRIDAY = r105;
        ChatJobEditWeekday r110 = new ChatJobEditWeekday("SATURDAY", 6);
        SATURDAY = r110;
        ChatJobEditWeekday[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f325221a = r111;
        f325222b = EnumEntriesKt.enumEntries(r111);
    }

    public static ChatJobEditWeekday[] values() {
        return (ChatJobEditWeekday[]) f325221a.clone();
    }

    public final String getLabel() {
        switch(a.f325223a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return gz8.f.b("scheduledTasks_newTask_frequency_sat");
    L15:
        return gz8.f.b("scheduledTasks_newTask_frequency_fri");
    L16:
        return gz8.f.b("scheduledTasks_newTask_frequency_thur");
    L17:
        return gz8.f.b("scheduledTasks_newTask_frequency_wed");
    L18:
        return gz8.f.b("scheduledTasks_newTask_frequency_tue");
    L19:
        return gz8.f.b("scheduledTasks_newTask_frequency_mon");
    L13:
        return gz8.f.b("scheduledTasks_newTask_frequency_sun");
    }

    public static ChatJobEditWeekday valueOf(String r100) {
        return (ChatJobEditWeekday) r27.a.a(ChatJobEditWeekday.class, r100);
    }

    public ChatJobEditWeekday(String r100, int r101) {
        super(r100, r101);
    }
}
