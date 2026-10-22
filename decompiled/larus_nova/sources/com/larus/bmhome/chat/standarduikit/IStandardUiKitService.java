package com.larus.bmhome.chat.standarduikit;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ-\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\tJ?\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService;", "", "createBrowserControlTipDialog", "Landroidx/fragment/app/DialogFragment;", WikiFolderPushPlugin.BLOCK_ID, "", "interactionType", "", "pcGuideRequestKey", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IStandardUiKitService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f308907a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000bJ@\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService$Companion;", "Lcom/larus/bmhome/chat/standarduikit/IStandardUiKitService;", "<init>", "()V", "createBrowserControlTipDialog", "Landroidx/fragment/app/DialogFragment;", WikiFolderPushPlugin.BLOCK_ID, "", "interactionType", "", "pcGuideRequestKey", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IStandardUiKitService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f308908c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IStandardUiKitService f308909b;

        static {
            f308908c = new Companion();
        }

        @Override // com.larus.bmhome.chat.standarduikit.IStandardUiKitService
        public final DialogFragment a(String r100, Integer r101, String r102, String r110, String r111) {
            return this.f308909b.a(r100, r101, r102, r110, r111);
        }

        private Companion() {
            IStandardUiKitService r100 = (IStandardUiKitService) ServiceManager.get().getService(IStandardUiKitService.class);
            if (r100 != null) goto L5;
            r100 = new StandardUiKitServiceNoop();
        L5:
            this.f308909b = r100;
        }
    }

    static {
        f308907a = Companion.f308908c;
    }

    DialogFragment a(String r100, Integer r101, String r102, String r103, String r104);
}
