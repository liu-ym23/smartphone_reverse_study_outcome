package com.ss.android.lark.watermark.userscope;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.dto.WatermarkData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ProcessSynchronizerV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f445317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f445318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WatermarkBroadcastReceiver f445319c;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/watermark/userscope/ProcessSynchronizerV3$WatermarkBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "onChanged", "Lkotlin/Function3;", "", "Lcom/ss/android/lark/watermark/dto/WatermarkData;", "", "", "onStrategyChanged", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "onReceive", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WatermarkBroadcastReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function3<String, WatermarkData, Boolean, Unit> f445320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<Integer, Boolean, Unit> f445321b;

        /* JADX WARN: Multi-variable type inference failed */
        public WatermarkBroadcastReceiver(Function3<? super String, ? super WatermarkData, ? super Boolean, Unit> r100, Function2<? super Integer, ? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "onChanged");
            Intrinsics.checkNotNullParameter(r101, "onStrategyChanged");
            this.f445320a = r100;
            this.f445321b = r101;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "intent");
            WatermarkData r102 = (WatermarkData) r101.getParcelableExtra("global_data");
            if (r102 == null) goto L5;
            this.f445320a.invoke("global_data", r102, Boolean.FALSE);
        L5:
            WatermarkData r103 = (WatermarkData) r101.getParcelableExtra("fallback_data");
            if (r103 == null) goto L8;
            this.f445320a.invoke("fallback_data", r103, Boolean.FALSE);
        L8:
            int r104 = r101.getIntExtra(BdpAppEventConstant.PARAMS_STRATEGY_NAME, 0);
            this.f445321b.invoke(Integer.valueOf(r104), Boolean.FALSE);
        }
    }

    public static final class a {
    }

    static {
    }

    @Inject
    public ProcessSynchronizerV3(com.ss.android.lark.storage.kv.storage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userKV");
        LarkKVStorage r101 = LarkKVStorage.f440926a;
        com.ss.android.lark.storage.a r102 = com.ss.android.lark.watermark.userscope.a.f445417a;
        r101.getClass();
        this.f445317a = LarkKVStorage.l(r100, r102, "common");
        this.f445318b = LarkContext.getApplication().getApplicationContext();
    }

    public final void a(int r100) {
        Intent r101 = new Intent("com.larksuite.android.wm");
        r101.setPackage(this.f445318b.getApplicationInfo().packageName);
        r101.putExtra(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r100);
        this.f445318b.sendBroadcast(r101);
    }

    public final void b(String r100, WatermarkData r101) {
        this.f445317a.putJSONObject(r100, r101);
        Intent r102 = new Intent("com.larksuite.android.wm");
        r102.setPackage(this.f445318b.getApplicationInfo().packageName);
        r102.putExtra(r100, r101);
        this.f445318b.sendBroadcast(r102);
    }
}
