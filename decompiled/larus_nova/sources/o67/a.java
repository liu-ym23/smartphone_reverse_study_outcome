package o67;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import com.ss.android.message.NotifyService;
import com.ss.android.message.log.LogService;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static boolean a(Context r100, String r101) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkContentProviders(r100, r101, "Push", Arrays.asList(new Component[]{Component.Builder.create(PushMultiProcessSharedProvider.class.getName()).setProcess(r100.getPackageName()).setAuthorities(r100.getPackageName() + ".push.SHARE_PROVIDER_AUTHORITY").build()})) & ManifestUtils.checkService(r100, r101, "Push", Arrays.asList(new Component[]{Component.Builder.create(NotifyService.class.getName()).setProcess(r100.getPackageName() + TTProcessUtils.MESSAGE_PROCESS_SUFFIX).addIntentFilter(new Component.IntentFilter(Arrays.asList(new String[]{"com.ss.android.message.action.PUSH_SERVICE"}))).build(), Component.Builder.create(LogService.class.getName()).setProcess(r100.getPackageName() + TTProcessUtils.MESSAGE_PROCESS_SUFFIX).build()}));
    }
}
