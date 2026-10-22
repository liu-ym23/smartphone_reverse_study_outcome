package com.bytedance.android.livesdk.livecommerce.room.api;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {
    void a(FragmentActivity r1, String r2, Window r3);

    void b(int r1);

    void c(boolean r1);

    void d(FragmentActivity r1, String r2, Window r3, Function2 r4);

    void e();

    void f(FragmentActivity r1, String r2, Window r3);

    Observable<ge.a> g(Context r1, ge.b r2);

    <T extends be.a> T getLogger(Class<T> r1);

    void h(String r1, Bundle r2, String r3);

    void i(ak2.f<String, String> r1);

    boolean insertLegalMessage(long r1, String r3, boolean r4);

    boolean isLinkmic();

    void jetDanmaku(String r1, long r2, String r4, String r5);

    void onCouponMessage(int r1, long r2, String r4, int r5, long r6);

    void onPurchasingIntentionAction();

    void previewCompShowEvent();

    void sendLogger(String r1, Map<String, String> r2);
}
