package com.bytedance.ee.bear.block;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.block.jira.JiraPlugin;
import com.bytedance.ee.bear.block.jira.e;
import com.bytedance.mt.protector.impl.PatternProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.ee.bear.block.b
    public final boolean b(String r2) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r2, "url");
        return PatternProtector.compile("(https?|s?ftp|ftps|nfs|ssh)?(.+\\.atlassian)|(.*jira.*\\..+)\\.(com|cn|tk|de|net|org|uk|info|nl|ru)").matcher(r2).find();
    }

    @Override // com.bytedance.ee.bear.block.b
    public final boolean a(String r1, FragmentActivity r2) {
        return JiraPlugin.interceptJiraUrl(r1, r2);
    }
}
