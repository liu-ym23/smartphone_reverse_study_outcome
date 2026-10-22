package com.obric.assistant.interaction.impl.essentialtask.ipc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskServiceKt;
import com.volcengine.zeus.provider.ContentProviderManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016JS\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J3\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0019J=\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001bJ&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J.\u0010!\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/ipc/EssentialTaskIPCProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "onCreate", XmlPullParser.NO_NAMESPACE, "query", "Landroid/database/Cursor;", ContentProviderManager.PROVIDER_URI, "Landroid/net/Uri;", "projection", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", XmlPullParser.NO_NAMESPACE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "handleQueryExecuteState", "callingPid", "callingProcessName", "getProcessNameByPid", "pid", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class EssentialTaskIPCProvider extends ContentProvider {
    private static final Uri AUTHORITY = null;
    public static final Companion Companion = null;
    public static final String KEY_IS_SUCCEED = "is_succeed";
    public static final String KEY_MESSENGER = "messenger";
    public static final String METHOD_QUERY_EXECUTE_STATE = "queryExecuteState";
    public static final int MSG_ON_EXECUTE_SUCCEED = 1;
    private static final String TAG = "EssentialTaskIPCProvider";
    private final CoroutineScope workScope;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/ipc/EssentialTaskIPCProvider$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "AUTHORITY", "Landroid/net/Uri;", "getAUTHORITY", "()Landroid/net/Uri;", "METHOD_QUERY_EXECUTE_STATE", "KEY_IS_SUCCEED", "KEY_MESSENGER", "MSG_ON_EXECUTE_SUCCEED", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Uri getAUTHORITY() {
            return EssentialTaskIPCProvider.access$getAUTHORITY$cp();
        }
    }

    public static /* synthetic */ void a(int r0, String r1, Job r2) {
        handleQueryExecuteState$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Messenger r0, IBinder.DeathRecipient r1, int r2, String r3, Throwable r4) {
        return handleQueryExecuteState$lambda$4(r0, r1, r2, r3, r4);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, ContentProviderManager.PROVIDER_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, ContentProviderManager.PROVIDER_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, ContentProviderManager.PROVIDER_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, ContentProviderManager.PROVIDER_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, ContentProviderManager.PROVIDER_URI);
        return 0;
    }

    static {
        Companion = new Companion(null);
        AUTHORITY = UriProtector.parse("content://com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        FLogger.a.i(TAG, "onCreate");
        return true;
    }

    public EssentialTaskIPCProvider() {
        this.workScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static final /* synthetic */ Uri access$getAUTHORITY$cp() {
        return AUTHORITY;
    }

    private final String getProcessNameByPid(int r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.m49constructorimpl(StringsKt.trim(FilesKt.readText$default(new PolarisFileWrapper("/proc/" + r6 + "/comm"), null, 1, null)).toString());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m52exceptionOrNullimpl(r0);
        if (r2 == null) goto L11;
        FLogger.a.w(TAG, "read process name failed, pid = " + r6 + ", errorMsg = " + r2.getMessage(), r2);
    L11:
        if (Result.m55isFailureimpl(r0) == false) goto L14;
        r0 = XmlPullParser.NO_NAMESPACE;
    L14:
        return (String) r0;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r0 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void handleQueryExecuteState$lambda$1(int r3, String r4, Job r5) {
        FLogger.a.i(TAG, "pid " + r3 + " process " + r4 + " is dead");
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r6, String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "method");
        int r0 = Binder.getCallingPid();
        String r1 = getProcessNameByPid(r0);
        FLogger.a.i(TAG, "call: method = " + r6 + ", callingPid = " + r0 + ", callingProcessName = " + r1);
        if (Intrinsics.areEqual(r6, METHOD_QUERY_EXECUTE_STATE) == true) goto L5;
        return null;
    L5:
        return handleQueryExecuteState(r7, r8, r0, r1);
    }

    private final Bundle handleQueryExecuteState(String r12, Bundle r13, int r14, String r15) {
        IEssentialTaskService r16 = IEssentialTaskServiceKt.getEssentialTaskServiceDelegate();
        Messenger r0 = null;
        if (r16 == null) goto L23;
        i1<Boolean> r3 = r16.isExecuteSucceedState();
        if (r3 == null) goto L23;
        boolean r17 = r3.getValue().booleanValue();
        if (r17 == true) goto L21;
        if (r13 == null) goto L11;
        r0 = (Messenger) r13.getParcelable(KEY_MESSENGER);
    L11:
        if (r0 == null) goto L21;
        Job r18 = BuildersKt.launch$default(this.workScope, null, null, new handleQueryExecuteState.watchJob.1(r3, r0, r14, r15, null), 3, null);
        a r2 = new a(r14, r15, r18);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        r0.getBinder().linkToDeath(r2, 0);     // Catch: Throwable -> L15
        Object r5 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.m52exceptionOrNullimpl(r5);
        if (r6 == null) goto L20;
        FLogger.a.w(TAG, "link to death failed: " + r6.getMessage() + ", pid = " + r14 + ", process name = " + r15 + ')', r6);
    L20:
        r18.invokeOnCompletion(new b(r0, r2, r14, r15));
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L21:
        Bundle r19 = new Bundle();
        r19.putBoolean(KEY_IS_SUCCEED, r17);
        return r19;
    L23:
        FLogger.a.w(TAG, "isExecuteSucceedState is null");
        return null;
    }

    private static final Unit handleQueryExecuteState$lambda$4(Messenger r1, IBinder.DeathRecipient r2, int r3, String r4, Throwable r5) {
        boolean r6 = r1.getBinder().unlinkToDeath(r2, 0);
        FLogger.a.i(TAG, "unlink to death " + r6 + ", pid = " + r3 + ", process name = " + r4);
        return Unit.INSTANCE;
    }
}
