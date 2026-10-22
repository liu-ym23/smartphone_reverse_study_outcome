package com.obric.assistant.interaction.api.service;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IObricShowOnLockedService;", "", "init", "", "setShowOnLocked", "activity", "Landroid/app/Activity;", "cancelShowOnLock", "isAllowShowOnLocked", "", "intent", "Landroid/content/Intent;", "addShowOnLockedClazz", "clazzName", "", "appMustInForeground", "checkIntent", "Lkotlin/Function1;", "removeShowOnLockedClazz", "checkActivityAuthenticationOnLockAsync", "activityIntent", "callback", "Lcom/obric/assistant/interaction/api/service/CheckActivityAuthenticationCallback;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricShowOnLockedService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean a(Intent r100) {
            return addShowOnLockedClazz$lambda$0(r100);
        }

        private static boolean addShowOnLockedClazz$lambda$0(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addShowOnLockedClazz$default(IObricShowOnLockedService r100, String r101, boolean r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = true;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = new b();
        L9:
            r100.addShowOnLockedClazz(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addShowOnLockedClazz");
        }
    }

    void addShowOnLockedClazz(String r100, boolean r101, Function1<? super Intent, Boolean> r102);

    void cancelShowOnLock(Activity r100);

    void checkActivityAuthenticationOnLockAsync(Intent r100, CheckActivityAuthenticationCallback r101);

    void init();

    boolean isAllowShowOnLocked(Activity r100);

    boolean isAllowShowOnLocked(Intent r100);

    void removeShowOnLockedClazz(String r100);

    void setShowOnLocked(Activity r100);
}
