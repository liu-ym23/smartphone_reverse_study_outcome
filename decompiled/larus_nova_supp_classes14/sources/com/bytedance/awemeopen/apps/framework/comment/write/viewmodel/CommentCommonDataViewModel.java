package com.bytedance.awemeopen.apps.framework.comment.write.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent.b;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentCommonDataViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/o;", "vm", "", "filterEventParamsFromVmInterface", "", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "previousPage", "getPreviousPage", "setPreviousPage", "Lr14/c;", "currentAweme", "Lr14/c;", "getCurrentAweme", "()Lr14/c;", "setCurrentAweme", "(Lr14/c;)V", "templateId", "getTemplateId", "setTemplateId", "Lorg/json/JSONObject;", "hostExtraParams", "Lorg/json/JSONObject;", "getHostExtraParams", "()Lorg/json/JSONObject;", "setHostExtraParams", "(Lorg/json/JSONObject;)V", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentCommonDataViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "CommonDataViewModel";
    private c currentAweme;
    private JSONObject hostExtraParams;
    private String previousPage;
    private String sceneId;
    private String templateId;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static CommentCommonDataViewModel a(ViewModelStoreOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            if ((r2 instanceof Fragment) == false) goto L10;
            Fragment r0 = (Fragment) r2;
            if (r0.isDetached() == false) goto L7;
            return null;
        L7:
            if (r0.getContext() != null) goto L10;
            return null;
        L10:
            ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
            r1.getClass();
            return (CommentCommonDataViewModel) new ViewModelProvider(r2, r1).get(CommentCommonDataViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final CommentCommonDataViewModel get(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public CommentCommonDataViewModel() {
    }

    public final c getCurrentAweme() {
        return this.currentAweme;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void filterEventParamsFromVmInterface(o r2) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        b.a(r2.getHostExtensionInfo());
        this.templateId = null;
    }

    public final void setCurrentAweme(c r1) {
        this.currentAweme = r1;
    }

    public final void setHostExtraParams(JSONObject r1) {
        this.hostExtraParams = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public final void setSceneId(String r1) {
        this.sceneId = r1;
    }

    public final void setTemplateId(String r1) {
        this.templateId = r1;
    }
}
