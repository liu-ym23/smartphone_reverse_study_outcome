package com.bytedance.ee.bear.block;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.block.jira.JiraPlugin;
import com.bytedance.ee.bear.block.jira.e;
import com.bytedance.mt.protector.impl.PatternProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.ee.bear.block.b
    public final boolean b(String r100) {
        int r101 = e.f216595a;
        Intrinsics.checkNotNullParameter(r100, "url");
        return PatternProtector.compile("(https?|s?ftp|ftps|nfs|ssh)?(.+\\.atlassian)|(.*jira.*\\..+)\\.(com|cn|tk|de|net|org|uk|info|nl|ru)").matcher(r100).find();
    }

    @Override // com.bytedance.ee.bear.block.b
    public final boolean a(String r100, FragmentActivity r101) {
        return JiraPlugin.interceptJiraUrl(r100, r101);
    }
}
