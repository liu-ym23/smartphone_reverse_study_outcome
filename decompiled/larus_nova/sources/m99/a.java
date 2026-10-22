package m99;

import com.google.gson.reflect.TypeToken;
import com.larus.extension.summary_card.api.model.SummaryCardMessageContent;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zd9.h;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: m99.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C6783a extends TypeToken<SummaryCardMessageContent> {
        public C6783a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<SummaryCardMessageContent> {
        public b() {
        }
    }

    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = null;
        if (f(r100) == false) goto L43;
        Map<String, String> r102 = r100.getExt();
        if (r102 == null) goto L46;
        String r103 = r102.get("feed_video_summary");
        if (r103 == null) goto L46;
        return r103;
    L46:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L33
        h r105 = h.f571481a;     // Catch: Throwable -> L33
        String r106 = r100.getContent();     // Catch: Throwable -> L33
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L44;
    L16:
        Object r108 = null;
    L27:
        SummaryCardMessageContent r109 = (SummaryCardMessageContent) r108;     // Catch: Throwable -> L33
        if (r109 == null) goto L30;
        String r110 = r109.getContent();     // Catch: Throwable -> L33
    L31:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r111) == true) goto L39;
        r101 = r111;
    L39:
        String r112 = (String) r101;
        if (r112 != null) goto L49;
        return "";
    L49:
        return r112;
    L30:
        r110 = null;
        goto L31
    L44:
        r105.getClass();     // Catch: Throwable -> L19
        r108 = Result.m9449constructorimpl(h.f571482b.fromJson(r106, new C6783a().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L33
        if (r113 == null) goto L25;
        c0 r114 = c0.f348199b;     // Catch: Throwable -> L33
        StringBuilder r115 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r113, "<this>");     // Catch: Throwable -> L33
        r115.append(ExceptionsKt.stackTraceToString(r113));     // Catch: Throwable -> L33
        r114.e("GsonHolder", r115.toString());     // Catch: Throwable -> L33
    L25:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L33
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L21
    L11:
        if (StringsKt.isBlank(r106) == true) goto L14;
        r107 = false;
    L33:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L43:
        return null;
    }

    public static final String b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f(r100) == false) goto L19;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L7;
        String r102 = r101.get("feed_video_summary_item_id");
    L8:
        if (r102 != null) goto L17;
        CommonVideoModel.a r103 = CommonVideoModel.Companion;
        String r104 = r100.getContent();
        r103.getClass();
        MediaEntityContainer r105 = CommonVideoModel.a.a(r104);
        if (r105 == null) goto L24;
        ArrayList<MediaEntity> r106 = r105.getVideo_list();
        if (r106 == null) goto L25;
        MediaEntity r107 = (MediaEntity) CollectionsKt.getOrNull(r106, 0);
        if (r107 != null) goto L27;
        return null;
    L27:
        return r107.getItem_id();
    L25:
        return null;
    L24:
        return null;
    L17:
        return r102;
    L7:
        r102 = null;
        goto L8
    L19:
        if (e(r100) == false) goto L28;
        Map<String, String> r108 = r100.getBusinessExt();
        if (r108 != null) goto L23;
        return null;
    L23:
        return r108.get("feed_video_summary_item_id");
    L28:
        return null;
    }

    public static final String c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = null;
        if (f(r100) == false) goto L45;
        Map<String, String> r102 = r100.getExt();
        if (r102 == null) goto L46;
        String r103 = r102.get("feed_video_summary_source");
        if (r103 == null) goto L46;
        return r103;
    L46:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L35
        h r105 = h.f571481a;     // Catch: Throwable -> L35
        String r106 = r100.getContent();     // Catch: Throwable -> L35
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L48;
    L26:
        Object r108 = null;
    L27:
        SummaryCardMessageContent r109 = (SummaryCardMessageContent) r108;     // Catch: Throwable -> L35
        if (r109 == null) goto L32;
        Integer r110 = r109.getSource();     // Catch: Throwable -> L35
        if (r110 == null) goto L32;
        String r111 = r110.toString();     // Catch: Throwable -> L35
    L33:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r112) == true) goto L41;
        r101 = r112;
    L41:
        String r113 = (String) r101;
        if (r113 != null) goto L51;
        return "";
    L51:
        return r113;
    L32:
        r111 = null;
        goto L33
    L48:
        r105.getClass();     // Catch: Throwable -> L19
        r108 = Result.m9449constructorimpl(h.f571482b.fromJson(r106, new b().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L35
        if (r114 == null) goto L25;
        c0 r115 = c0.f348199b;     // Catch: Throwable -> L35
        StringBuilder r116 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r114, "<this>");     // Catch: Throwable -> L35
        r116.append(ExceptionsKt.stackTraceToString(r114));     // Catch: Throwable -> L35
        r115.e("GsonHolder", r116.toString());     // Catch: Throwable -> L35
    L25:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L35
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
        goto L21
    L11:
        if (StringsKt.isBlank(r106) == true) goto L14;
        r107 = false;
    L35:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L45:
        return null;
    }

    public static final boolean d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f(r100) == true) goto L5;
        return false;
    L5:
        if (o0.d(r100.getMessageId()) == false) goto L7;
        return true;
    L7:
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L10;
        String r102 = r101.get("feed_summary_expand");
    L12:
        return Intrinsics.areEqual(r102, "1");
    L10:
        r102 = null;
        goto L12
    }

    public static final boolean e(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getContentType() != 2) goto L13;
        String r101 = r100.getLocalMessageId();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.contains$default(r101, "-aweme", false, 2, null) != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public static final boolean f(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getContentType() == 800) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getBizContentType(), "video_summary") == false) goto L10;
        return true;
    L10:
        return false;
    }
}
