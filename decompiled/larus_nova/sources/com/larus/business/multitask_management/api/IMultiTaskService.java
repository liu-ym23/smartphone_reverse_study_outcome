package com.larus.business.multitask_management.api;

import androidx.fragment.app.DialogFragment;
import com.larus.business.multitask_management.impl.fullscreen.MultiTaskManagementFullscreenFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/larus/business/multitask_management/api/IMultiTaskService;", "", "init", "", "getMultiTaskManagementFragment", "Landroidx/fragment/app/DialogFragment;", "enterFrom", "", "getMultiTaskManagementFullscreenFragment", "Landroidx/fragment/app/Fragment;", "isMultiTaskManagementAccountEligible", "", "isMultiTaskManagementEntranceEnabled", "isMultiTaskManagementFloatWindowEnabled", "isMultiTaskManagementEnabled", "showMultiTaskFloatWindow", "hideMultiTaskFloatWindow", "expandMultiTaskFloatWindow", "animate", "collapseMultiTaskFloatWindow", "isMultiTaskFloatWindowExpanded", "presentingTaskListType", "closeMultiTaskPage", "resolveLocalIconResource", "", "uri", "(Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMultiTaskService {
    String i();

    void init();

    String m();

    boolean n();

    void o();

    void p(boolean r100);

    boolean q();

    Integer r(String r100);

    DialogFragment s(String r100);

    MultiTaskManagementFullscreenFragment t(String r100);

    boolean u();
}
