package com.bytedance.awemeopen.domain.comment;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class CommentListDomain {
    public CommentListDomain() {
    }

    public static void a(final Context r100, final String r101, final a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "commentId");
        Intrinsics.checkNotNullParameter(r102, "config");
        AoPool.a(new CommentListDomain$delComment$1(r100, r101, r102));
    }

    public static void c(final Context r100, final String r101, final long r110, final c r111) {
        final int r102 = 20;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "aid");
        Intrinsics.checkNotNullParameter(r111, "config");
        AoPool.a(new CommentListDomain$getCommentList$1(r100, r101, r110, r102, r111));
    }

    public static void b(final String r100, final String r101, final int r102, final b r110, final d r111) {
        AoPool.a(new CommentListDomain$diggToServer$1(r100, r101, r102, r110, r111));
    }

    public static void e(final Context r100, final String r110, final String r111, final String r112, final String r113, final f r114, final e r115) {
        AoPool.a(new CommentListDomain$publishCommentSever$1(r100, r110, r111, r112, r113, r114, r115));
    }

    public static void d(final Context r110, final String r111, final long r112, final String r210, final String r211, final int r212, final Integer r213, final Integer r214, final String r215, final c r216) {
        final int r100 = 3;
        final String r101 = "";
        final String r113 = "";
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "commentId");
        Intrinsics.checkNotNullParameter(r216, "config");
        AoPool.a(new CommentListDomain$getReplyList$1(r110, r111, r112, r100, r210, r211, r101, r212, r113, r213, r214, r215, r216));
    }
}
