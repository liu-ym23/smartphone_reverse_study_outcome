package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.DiffComments;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class DataEntity implements BaseJSModel {
    private String business;
    private Entity data;

    public static class Entity implements BaseJSModel {
        private BodyEntity body;
        private HeaderEntity header;
        private IdentifierEntity identifier;
        private String operation;

        public static class BodyEntity implements BaseJSModel {
            private int code;
            private String data;
            private Extra extra;
            private String msg;

            public static class Extra implements BaseJSModel {
                private String notNotifyUsers;

                public Extra() {
                }

                public String getNotNotifyUsers() {
                    return this.notNotifyUsers;
                }

                public void setNotNotifyUsers(String r100) {
                    this.notNotifyUsers = r100;
                }
            }

            public static class PublishEntity implements BaseJSModel {
                private Comment comment;
                private boolean isNewComment;
                private String localCommentId;

                public static class Comment implements BaseJSModel {
                    private String commentId;

                    public Comment() {
                    }

                    public String getCommentId() {
                        return this.commentId;
                    }

                    public void setCommentId(String r100) {
                        this.commentId = r100;
                    }
                }

                public PublishEntity() {
                }

                public Comment getComment() {
                    return this.comment;
                }

                public String getLocalCommentId() {
                    return this.localCommentId;
                }

                public boolean isNewComment() {
                    return this.isNewComment;
                }

                public void setComment(Comment r100) {
                    this.comment = r100;
                }

                public void setLocalCommentId(String r100) {
                    this.localCommentId = r100;
                }

                public void setNewComment(boolean r100) {
                    this.isNewComment = r100;
                }
            }

            public static class QueryCommentData implements BaseJSModel {
                private String commentId;
                private boolean noPermission;

                public QueryCommentData() {
                }

                public String getCommentId() {
                    return this.commentId;
                }

                public boolean isNoPermission() {
                    return this.noPermission;
                }

                public void setCommentId(String r100) {
                    this.commentId = r100;
                }

                public void setNoPermission(boolean r100) {
                    this.noPermission = r100;
                }
            }

            public static class ResultEntity implements BaseJSModel {
                private Comments allComments;
                private CommentBean comment;
                private DiffComments diffComments;

                public static class Comments implements BaseJSModel {
                    private List<CommentBean> comments;
                    private List<CommentBean> finishComments;

                    public Comments() {
                    }

                    public List<CommentBean> getComments() {
                        return this.comments;
                    }

                    public List<CommentBean> getFinishComments() {
                        return this.finishComments;
                    }

                    public void setComments(List<CommentBean> r100) {
                        this.comments = r100;
                    }

                    public void setFinishComments(List<CommentBean> r100) {
                        this.finishComments = r100;
                    }
                }

                public ResultEntity() {
                }

                public Comments getAllComments() {
                    return this.allComments;
                }

                public CommentBean getComment() {
                    return this.comment;
                }

                public DiffComments getDiffComments() {
                    return this.diffComments;
                }

                public void setAllComments(Comments r100) {
                    this.allComments = r100;
                }

                public void setComment(CommentBean r100) {
                    this.comment = r100;
                }

                public void setDiffComments(DiffComments r100) {
                    this.diffComments = r100;
                }
            }

            public BodyEntity() {
            }

            public int getCode() {
                return this.code;
            }

            public String getData() {
                return this.data;
            }

            public Extra getExtra() {
                return this.extra;
            }

            public String getMsg() {
                return this.msg;
            }

            public void setCode(int r100) {
                this.code = r100;
            }

            public void setData(String r100) {
                this.data = r100;
            }

            public void setExtra(Extra r100) {
                this.extra = r100;
            }

            public void setMsg(String r100) {
                this.msg = r100;
            }
        }

        public static class HeaderEntity implements BaseJSModel {
            private String requestId;

            public HeaderEntity() {
            }

            public String getRequestId() {
                return this.requestId;
            }

            public void setRequestId(String r100) {
                this.requestId = r100;
            }
        }

        public static class IdentifierEntity implements BaseJSModel {
            private String token;
            private int type;

            public IdentifierEntity() {
            }

            public String getToken() {
                return this.token;
            }

            public int getType() {
                return this.type;
            }

            public void setToken(String r100) {
                this.token = r100;
            }

            public void setType(int r100) {
                this.type = r100;
            }
        }

        public Entity() {
        }

        public BodyEntity getBody() {
            return this.body;
        }

        public HeaderEntity getHeader() {
            return this.header;
        }

        public IdentifierEntity getIdentifier() {
            return this.identifier;
        }

        public String getOperation() {
            return this.operation;
        }

        public void setBody(BodyEntity r100) {
            this.body = r100;
        }

        public void setHeader(HeaderEntity r100) {
            this.header = r100;
        }

        public void setIdentifier(IdentifierEntity r100) {
            this.identifier = r100;
        }

        public void setOperation(String r100) {
            this.operation = r100;
        }
    }

    public DataEntity() {
    }

    public String getBusiness() {
        return this.business;
    }

    public Entity getData() {
        return this.data;
    }

    public void setBusiness(String r100) {
        this.business = r100;
    }

    public void setData(Entity r100) {
        this.data = r100;
    }
}
