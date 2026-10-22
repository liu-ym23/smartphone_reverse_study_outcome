package pab;

import com.bytedance.lark.pb.calendar.v1.GetParsedRruleTextResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f528402a = null;

    static {
        f528402a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        GetParsedRruleTextResponse r101 = GetParsedRruleTextResponse.ADAPTER.decode(r100);
        return new String[]{r101.parsed_rrule, r101.freq_part, r101.until_part};
    }
}
