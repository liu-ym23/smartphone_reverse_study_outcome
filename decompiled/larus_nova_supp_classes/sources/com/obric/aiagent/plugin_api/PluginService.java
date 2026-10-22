package com.obric.aiagent.plugin_api;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.agent.provider.AgentOpenApiProvider;
import com.obric.aiagent.apm.AlogFileProvider;
import com.obric.aiagent.appintent.CapabilityHandleService;
import com.obric.aiagent.assistant_card.CardProviderService;
import com.obric.aiagent.executionengine.capabilitymanager.publish.RegistrationService;
import com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerService;
import com.obric.aiagent.executionengine.scheduler.impl.ScheduleService;
import com.obric.aiagent.interaction.provider.HybridAbilityProvider;
import com.obric.aiagent.ipc.assistant.AssistantIDLServiceApi;
import com.obric.aiagent.ipc.assistant.ProxyPackageResetReceiver;
import com.obric.aiagent.plugin_api.stub.AIAgentStandardPortraitActivity;
import com.obric.aiagent.skill.credentials.SidecarAuthStarterActivity;
import com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailStubActivity;
import com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewStubActivity;
import com.obric.aiagent.skill.manager.impl.ui.SkillManagementStubActivity;
import com.obric.aiagent.skill.manager.impl.ui.SkillSearchStubActivity;
import com.obric.aiagent.skill.manager.impl.ui.SkillShopStubActivity;
import com.obric.aiagent.skill.ovirt.impl.ui.SkillSettingsStubActivity;
import com.obric.aiagent.taskmanager.ConditionTaskAlarmReceiver;
import com.obric.aiagent.taskmanager.TimerTaskAlarmReceiver;
import com.obric.autoaction.app.launcherpage.LauncherPageStubActivity;
import com.obric.autoaction.app.launcherpage.PinShortCutStubActivity;
import com.obric.autoaction.app.launcherpage.conditionnew.ConditionEventDetailStubActivityNew;
import com.obric.autoaction.app.launcherpage.donation.RecordDataListStubActivity;
import com.obric.autoaction.app.launcherpage.history.historydetail.HistoryDetailStubActivity;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeStubActivity;
import com.obric.autoaction.app.launcherpage.shortcutdetail.ShortCutCreateStubActivity;
import com.obric.autoaction.app.launcherpage.shortcutdetail.ShortcutDetailStubActivity;
import com.obric.autoaction.presentation.FloatingWindowService;
import com.obric.autoaction.presentation.SurfaceCardStubActivity;
import com.obric.autoaction.presentation.provider.OAutoStateProvider;
import com.obric.autoaction.userreport.TransparentReportStubActivity;
import com.obric.autogui.agents.stateprovider.AgentStateProvider;
import com.obric.autogui.effects.VDPlayerEffectProvider;
import com.obric.autogui.platforms.tools.platstrategy.StandardPermissionAcquiringStubActivity;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import el9.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginService {
    private static final String ALOG_FILE_PROVIDER = "com.obric.aiagent.apm.impl.AlogFileProvider";
    public static final Object[] EXTERNAL_COMPONENTS = null;
    private static final String TAG = "PluginService";
    public static IPluginApi api = null;
    public static final String pluginPkgName = "com.obric.aiagent.plugin";

    public PluginService() {
    }

    public static /* synthetic */ void a() {
        lambda$callPluginByReflect$0();
    }

    private static /* synthetic */ void lambda$callPluginByReflect$0() {
    }

    static {
        EXTERNAL_COMPONENTS = new Object[]{ExportedDebugActivity.class, SkillShopStubActivity.class, SkillManagementStubActivity.class, SkillSearchStubActivity.class, SkillDetailPreviewStubActivity.class, SkillCollectionDetailStubActivity.class, SkillSettingsStubActivity.class, SidecarAuthStarterActivity.class, LauncherPageStubActivity.class, SurfaceCardStubActivity.class, AIAgentStandardPortraitActivity.class, ConditionEventDetailStubActivityNew.class, ShortcutDetailStubActivity.class, ShortCutCreateStubActivity.class, KnowledgeStubActivity.class, HistoryDetailStubActivity.class, RecordDataListStubActivity.class, PinShortCutStubActivity.class, TransparentReportStubActivity.class, StandardPermissionAcquiringStubActivity.class, AssistantIDLServiceApi.class, TaskManagerService.class, ScheduleService.class, RegistrationService.class, CapabilityHandleService.class, CardProviderService.class, FloatingWindowService.class, OAutoStateProvider.class, AgentStateProvider.class, VDPlayerEffectProvider.class, HybridAbilityProvider.class, AgentOpenApiProvider.class, AlogFileProvider.class, AwarenessCallbackProxyProvider.class, TimerTaskAlarmReceiver.class, ConditionTaskAlarmReceiver.class, ProxyPackageResetReceiver.class, "com.obric.aiagent.plugin.Activity_aiagent_standard", "com.obric.aiagent.skill.manager.impl.ui.SkillShopStarterActivity", "com.obric.aiagent.skill.manager.impl.ui.SkillManagementStarterActivity", "com.obric.aiagent.skill.manager.impl.ui.SkillSearchStarterActivity", "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewStarterActivity", "com.obric.aiagent.skill.manager.impl.ui.SkillCollectionDetailStarterActivity", "com.obric.aiagent.skill.ovirt.impl.ui.SkillSettingsStarterActivity", "com.obric.autoaction.app.launcherpage.LauncherPageStarterActivity", "com.obric.autoaction.app.presentation.SurfaceCardStarterActivity", "com.obric.autoaction.app.launcherpage.ConditionEventDetailStarterActivity", "com.obric.autoaction.app.launcherpage.ShortCutCreateStarterActivity"};
    }

    public static void initPlugin() {
        IPluginApi r0 = getApi();
        if (r0 == null) goto L6;
        r0.init();
        return;
    }

    public static IPluginApi getApi() {
        return api;
    }

    public static void bindPluginServiceByHost(Context r4) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r4, "com.obric.aiagent.plugin_impl.PluginService"));
        ZeusTransformUtils.bindService(r4, r0, new 2(), 0, "com.obric.aiagent.plugin");
    }

    public static View callPluginByReflect(Context r5) {
        if (preparePlugin(r5, new a()) == false) goto L12;
        return (View) INVOKEVIRTUAL_com_obric_aiagent_plugin_api_PluginService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(Zeus.getPlugin("com.obric.aiagent.plugin").mClassLoader, "com.obric.aiagent.plugin_impl.PluginView").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5});
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static void disableComponents(Context r2) {
        if (r2 != null) goto L7;
        return;
    L7:
        updateComponentsState(r2, false, EXTERNAL_COMPONENTS);     // Catch: Exception -> L6
        return;
    }

    public static void enableComponents(Context r2) {
        if (r2 != null) goto L7;
        return;
    L7:
        updateComponentsState(r2, true, EXTERNAL_COMPONENTS);     // Catch: Exception -> L6
        return;
    }

    public static void init(Context r1) {
        SystemClock.elapsedRealtime();
        Zeus.init((Application) r1.getApplicationContext(), true);
        SystemClock.elapsedRealtime();
        SystemClock.elapsedRealtime();
        Zeus.installFromDownloadDir();
        SystemClock.elapsedRealtime();
    }

    public static void insertProviderByHost(Context r3) {
        ContentResolver r4 = r3.getContentResolver();
        ContentValues r0 = new ContentValues();
        r0.put("from", "host");
        ZeusProviderTransform.insert(r4, UriProtector.parse("content://com.obric.aiagent.plugin.pluginprovider"), r0, "com.obric.aiagent.plugin");
    }

    public static boolean preparePlugin(Context r1) {
        return preparePlugin(r1, null);
    }

    public static void sendBroadcastByHost(Context r2) {
        Toast.makeText(r2, "仅支持动态广播，且需要在插件中注册。宿主中注册比较麻烦，这里不提供Demo", 0).show();
    }

    public static void startPluginServiceByHost(Context r3) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r3, "com.obric.aiagent.plugin_impl.PluginService"));
        ZeusTransformUtils.startService(r3, r0, "com.obric.aiagent.plugin");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_obric_aiagent_plugin_api_PluginService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static boolean preparePlugin(Context r3, OnPluginInstallListener r4) {
        if (Zeus.isPluginInstalled("com.obric.aiagent.plugin") == true) goto L7;
        Toast.makeText(r3, "插件未安装，不可用，注册安装的回调", 0).show();
        Zeus.registerPluginStateListener(new 1(r4));
        return false;
    L7:
        if (Zeus.isPluginLoaded("com.obric.aiagent.plugin") == false) goto L10;
        return true;
    L10:
        SystemClock.elapsedRealtime();
        boolean r5 = Zeus.loadPlugin("com.obric.aiagent.plugin");
        SystemClock.elapsedRealtime();
        if (r5 == false) goto L13;
        Toast.makeText(r3, "插件加载成功，可用", 0).show();
    L14:
        return r5;
    L13:
        Toast.makeText(r3, "插件加载失败，不可用", 0).show();
        goto L14
    }

    public static List<File> getALogFiles(Context r5, long r6, long r8) {
        ArrayList r0 = new ArrayList();
        Uri r1 = UriProtector.parse("content://com.obric.aiagent.apm.impl.AlogFileProvider");
        Bundle r3 = new Bundle();
        r3.putLong("start_time", r6);
        r3.putLong("end_time", r8);
        Bundle r7 = r5.getContentResolver().call(r1, "getALogFiles", null, r3);     // Catch: Exception -> L13
        Objects.toString(r7);     // Catch: Exception -> L13
        if (r7 == null) goto L12;
        ArrayList<String> r9 = r7.getStringArrayList("alog_files_path");     // Catch: Exception -> L13
        if (r9 == null) goto L12;
        Iterator<String> r10 = r9.iterator();     // Catch: Exception -> L13
    L9:
        if (r10.hasNext() == false) goto L12;
        r0.add(new PolarisFileWrapper(r10.next()));     // Catch: Exception -> L13
    L12:
        return r0;
    }

    private static void updateComponentsState(Context r6, boolean r7, Object[] r8) {
        PackageManager r0 = r6.getPackageManager();
        if (r7 == false) goto L5;
        int r9 = 1;
    L6:
        String r10 = r6.getPackageName();
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.length == 0) goto L40;
        int r2 = r8.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L30;
        Object r4 = r8[r3];
        if ((r4 instanceof Class) == false) goto L17;
        String r5 = ((Class) r4).getName();
    L31:
        r0.setComponentEnabledSetting(new ComponentName(r10, r5), r9, 1);     // Catch: Exception -> L21 IllegalArgumentException -> L23 SecurityException -> L25
    L28:
        r3 = r3 + 1;
    L23:
        e = move-exception;
        e.getMessage();
    L25:
        e = move-exception;
        e.getMessage();
    L21:
        e = move-exception;
        e.getMessage();
        goto L28
    L17:
        if ((r4 instanceof String) == false) goto L28;
        r5 = (String) r4;
        goto L31
    L30:
        return;
    L40:
        return;
    L5:
        r9 = 2;
        goto L6
    }
}
