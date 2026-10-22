package com.obric.assistant.wakeup.statistics.api;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI;", "", "markEstablishStart", "", "markEstablishResult", "result", "Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI$Result;", "rawScoState", "", "cancelInFlight", "Result", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBluetoothScoEstablishStatisticsAPI {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI$Result;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", State.DISCONNECTED, "ERROR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result CONNECTED = null;
        public static final Result DISCONNECTED = null;
        public static final Result ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f394473a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394474b = null;

        public static EnumEntries<Result> getEntries() {
            return f394474b;
        }

        static {
            Result r100 = new Result("CONNECTED", 0);
            CONNECTED = r100;
            Result r101 = new Result(State.DISCONNECTED, 1);
            DISCONNECTED = r101;
            Result r102 = new Result("ERROR", 2);
            ERROR = r102;
            Result[] r103 = {r100, r101, r102};
            f394473a = r103;
            f394474b = EnumEntriesKt.enumEntries(r103);
        }

        public static Result[] values() {
            return (Result[]) f394473a.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) a.a(Result.class, r100);
        }

        public Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a(Result r100, int r101);

    void b();
}
