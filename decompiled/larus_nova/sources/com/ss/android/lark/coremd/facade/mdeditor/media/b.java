package com.ss.android.lark.coremd.facade.mdeditor.media;

import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.edittors.e;
import hob.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends e {
    @Override // com.ss.android.lark.keyboard.edittext2.edittors.e
    public final void U(final SpannableStringBuilder r100, final g r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        final String r102 = UIUtils.getString(c.a.a(this).getContext(), R.string.Lark_Legacy_MessagePoVideo);
        IMMediaExtend.f419669q.b(new IMMediaMarkdownEditor$onInsert$1(r102, r101, this, r100));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.e, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, g r101, int r102) {
        U(r100, r101);
    }
}
