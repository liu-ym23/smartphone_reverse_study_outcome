package zbc;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.card.audio.CardAudioInfo;
import com.ss.android.lark.widget.light.e;
import com.ss.android.lark.widget.light.processor.j;
import com.ss.android.lark.widget.light.span.d;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ncc.g;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements j<CardAudioInfo> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r210, g r211, SpanInfo r212, e r213) {
        CardAudioInfo r110 = (CardAudioInfo) r212;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "spanBuilder");
        Intrinsics.checkNotNullParameter(r110, "spanInfo");
        Intrinsics.checkNotNullParameter(r213, "params");
        String r111 = r110.text;
        Map r112 = new ArrayMap();
        r112.put(zbc.a.class.getSimpleName(), new zbc.a(r210, r110.getAudioDuration(), r110.getLoadingAnim(), r110.getBgColor(), r110.textColor, r110.getShowTime(), r110.getIconResId(), r110.getIconColor(), r110.getIconSize(), r110.getOriginalTextSize(), r110.textSize, r110.getIconTextGap(), r110.getBgHeight(), r110.getBgPaddingLeft(), r110.getBgPaddingRight(), r210.getResources().getDimensionPixelSize(R.dimen.number_tag_background_white_padding_start), r210.getResources().getDimensionPixelSize(R.dimen.number_tag_background_white_padding_end)));
        r211.c(r111, r112, 33);
        r211.setSpan(new d(new mcc.d.a("markdown_audio", r110.getContentID(), null, 4)), r211.length() - r111.length(), r211.length(), 33);
    }
}
