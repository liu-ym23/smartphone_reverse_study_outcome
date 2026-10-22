package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionListSearchButton;", "Landroid/widget/FrameLayout;", "", "showElevation", "", "setButtonElevation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionListSearchButton extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final CardView a;

    public static final class a {
        public static String a(String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r4, "rawSchema");
            Uri.Builder r11 = UriProtector.parse(r4).buildUpon();
            r11.appendQueryParameter("enter_from_method", l0.i("enter_method"));
            r11.appendQueryParameter("enter_from_second", l0.d());
            if (r9 != null) goto L21;
            r9 = null;
        L15:
            JSONObject r0 = new JSONObject();
            r0.put("live_room_author_id", r5);
            r0.put("live_room_id", r6);
            r0.put("entrance_info", r9);
            r0.put("height_percent", String.valueOf(73));
            Unit r12 = Unit.INSTANCE;
            r11.appendQueryParameter("common_search_params", r0.toString());
            JSONObject r13 = new JSONObject();
            JSONObject r14 = new JSONObject();
            Iterator<Map.Entry<String, String>> r15 = l0.g().entrySet().iterator();
        L17:
            if (r15.hasNext() == false) goto L19;
            Map.Entry<String, String> r1 = r15.next();
            r14.put(r1.getKey(), r1.getValue());
            goto L17
        L19:
            Unit r16 = Unit.INSTANCE;
            r13.put("general_params", r14.toString());
            r13.put("promotion_live_list_config", r10);
            r13.put("author_sell_score", r8);
            r13.put("live_list_channel", r7);
            r11.appendQueryParameter("promotion_extra", r13.toString());
            return r11.build().toString();
        L21:
            JSONObject r2 = z1.g(Uri.decode(r9));     // Catch: Exception -> L12
            if (r2 == null) goto L15;
            r2.put("carrier_source", r2.optString("enter_from_merge"));     // Catch: Exception -> L12
            r2.put("source_method", r2.optString("enter_method"));     // Catch: Exception -> L12
            String r3 = r2.toString();     // Catch: Exception -> L12
            if (r3 == null) goto L15;
            String r17 = Uri.encode(r3);     // Catch: Exception -> L12
            if (r17 == null) goto L15;
            r9 = r17;
        L12:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L15
        }
    }

    static {
    }

    public PromotionListSearchButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionListSearchButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setButtonElevation(boolean r3) {
        CardView r0 = this.a;
        if ((r0 instanceof CardView) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L11;
        if (r3 == false) goto L8;
        float r4 = UtilityKotlinExtentionsKt.c(15);
    L9:
        r0.setCardElevation(r4);
        return;
    L8:
        r4 = 0.0f;
        goto L9
    }

    public PromotionListSearchButton(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        CardView r8 = new CardView(getContext());
        View r9 = new View(getContext());
        r9.setBackgroundResource(2131248066);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(16), UtilityKotlinExtentionsKt.d(16));
        r0.gravity = 16;
        r0.leftMargin = UtilityKotlinExtentionsKt.d(13);
        Unit r1 = Unit.INSTANCE;
        r9.setLayoutParams(r0);
        r8.addView(r9);
        this.a = r8;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(48), UtilityKotlinExtentionsKt.d(28));
        r10.gravity = 8388613;
        r10.topMargin = -UtilityKotlinExtentionsKt.d(1);
        r8.setLayoutParams(r10);
        r8.setBackgroundColor(th.a.a(r5, 2131106174));
        setBackgroundColor(0);
        addView(r8);
    }

    public /* synthetic */ PromotionListSearchButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
