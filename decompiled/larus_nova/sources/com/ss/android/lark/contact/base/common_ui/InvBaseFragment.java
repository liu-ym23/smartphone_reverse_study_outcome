package com.ss.android.lark.contact.base.common_ui;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", LiveCommonConstants.REASON_ON_DEDTROY, "", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InvBaseFragment extends BaseFragment {
    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideKeyboard(getActivity());
    }

    public InvBaseFragment() {
    }
}
